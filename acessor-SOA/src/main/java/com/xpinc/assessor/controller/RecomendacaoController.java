package com.xpinc.assessor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpinc.assessor.dto.RecomendacaoRequest;
import com.xpinc.assessor.dto.RecomendacaoResponse;
import com.xpinc.assessor.service.RecomendacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/recomendacoes")
public class RecomendacaoController {
	private final RecomendacaoService service;

	public RecomendacaoController(RecomendacaoService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<List<RecomendacaoResponse>> recomendar(@RequestBody @Valid RecomendacaoRequest req) {
		var carteiras = service.recomendar(req.perfil(), req.prazo());
		var resp = new ArrayList<RecomendacaoResponse>();
		int i = 0;
		for (var c : carteiras)
			resp.add(new RecomendacaoResponse(c.getId(), List.of("conservadora", "balanceada", "arrojada").get(i++),
					"MVP"));
		return ResponseEntity.ok(resp);
	}
}