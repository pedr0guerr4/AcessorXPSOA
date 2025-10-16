package com.xpinc.assessor.controller;

import com.xpinc.assessor.domain.UserAccount;
import com.xpinc.assessor.domain.UserRole;
import com.xpinc.assessor.dto.AuthRequest;
import com.xpinc.assessor.dto.AuthResponse;
import com.xpinc.assessor.dto.SignupRequest;
import com.xpinc.assessor.repository.UserAccountRepository;
import com.xpinc.assessor.security.JwtService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthenticationManager authManager;
	private final JwtService jwtService;
	private final UserAccountRepository repo;
	private final BCryptPasswordEncoder encoder;

	public AuthController(AuthenticationManager authManager, JwtService jwtService, UserAccountRepository repo,
			BCryptPasswordEncoder encoder) {
		this.authManager = authManager;
		this.jwtService = jwtService;
		this.repo = repo;
		this.encoder = encoder;
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequest req) {
		var auth = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
		authManager.authenticate(auth);

		var user = repo.findByUsername(req.getUsername()).orElseThrow();
		var token = jwtService.generateToken(user);
		return ResponseEntity.ok(new AuthResponse(token));
	}

	@PostMapping("/signup")
	public ResponseEntity<Void> signup(@RequestBody @Valid SignupRequest req) {
		if (repo.existsByUsername(req.getUsername())) {
			return ResponseEntity.status(409).build();
		}
		var roles = (req.getRoles() == null || req.getRoles().isEmpty()) ? Set.of(UserRole.ROLE_USER) : req.getRoles();

		var user = new UserAccount(req.getUsername(), encoder.encode(req.getPassword()), roles);
		var saved = repo.save(user);
		return ResponseEntity.created(URI.create("/users/" + saved.getId())).build();
	}
}
