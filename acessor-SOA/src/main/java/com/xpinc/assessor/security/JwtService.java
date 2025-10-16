package com.xpinc.assessor.security;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xpinc.assessor.domain.UserAccount;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${app.security.jwt.secret}")
	private String secret;

	@Value("${app.security.jwt.expiration}")
	private long expiration;

	public String generateToken(UserAccount user) {
		var now = new Date();
		var expiry = new Date(now.getTime() + expiration);

		var roles = user.getRoles().stream().map(Enum::name).collect(Collectors.toList());

		return Jwts.builder().setSubject(user.getUsername()).claim("roles", roles).setIssuedAt(now)
				.setExpiration(expiry).signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
				.compact();
	}

	public String getUsername(String token) {
		return parser(token).getBody().getSubject();
	}

	public boolean isValid(String token) {
		try {
			parser(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	private Jws<Claims> parser(String token) {
		return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token);
	}
}
