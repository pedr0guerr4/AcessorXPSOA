package com.xpinc.assessor.controller;

import com.xpinc.assessor.dto.RecomendacaoRequest;
import com.xpinc.assessor.dto.RecomendacaoResponse;
import com.xpinc.assessor.service.RecomendacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recomendacoes")
public class RecomendacaoController {

    private final RecomendacaoService service;
    public RecomendacaoController(RecomendacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RecomendacaoResponse> recomendar(@RequestBody RecomendacaoRequest req) {
        return ResponseEntity.ok(service.gerar(req));
    }
}