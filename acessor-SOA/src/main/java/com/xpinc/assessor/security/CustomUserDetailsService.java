package com.xpinc.assessor.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.xpinc.assessor.repository.UserAccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserAccountRepository repo;

	public CustomUserDetailsService(UserAccountRepository repo) {
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = repo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

		var auths = user.getRoles().stream().map(Enum::name).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toSet());

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auths);
	}
}
