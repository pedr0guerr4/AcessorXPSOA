package com.xpinc.assessor.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpinc.assessor.domain.UserAccount;
import com.xpinc.assessor.domain.UserRole;
import com.xpinc.assessor.repository.UserAccountRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthIntegrationTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper om;
	@Autowired
	UserAccountRepository repo;
	@Autowired
	BCryptPasswordEncoder encoder;

	@BeforeEach
	void seed() {
		repo.deleteAll();
		var u = new UserAccount("admin", encoder.encode("admin123"), Set.of(UserRole.ROLE_ADMIN, UserRole.ROLE_USER));
		repo.save(u);
	}

	@Test
	void loginEChamaEndpointProtegido() throws Exception {
		var body = """
				{"username":"admin","password":"admin123"}
				""";
		var res = mockMvc.perform(post("/auth/login").contentType(MediaType.APPLICATION_JSON).content(body))
				.andExpect(status().isOk()).andReturn();

		var json = res.getResponse().getContentAsString();
		String token = om.readTree(json).get("token").asText();

		mockMvc.perform(get("/api/clientes").header("Authorization", "Bearer " + token)).andExpect(status().isOk());
	}
}