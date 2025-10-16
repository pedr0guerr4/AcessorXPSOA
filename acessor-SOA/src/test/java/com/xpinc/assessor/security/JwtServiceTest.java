package com.xpinc.assessor.security;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import com.xpinc.assessor.domain.UserAccount;
import com.xpinc.assessor.domain.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class JwtServiceTest {

	@Test
	void geraEValidaToken() {
		var svc = new JwtService();
		ReflectionTestUtils.setField(svc, "secret", "uma-chave-secreta-qualquer-de-256-bits-...-preencher");
		ReflectionTestUtils.setField(svc, "expiration", 60000L);

		var user = new UserAccount("alice", "x", Set.of(UserRole.ROLE_USER));
		var token = svc.generateToken(user);
		assertTrue(svc.isValid(token));
		assertEquals("alice", svc.getUsername(token));
	}
}
