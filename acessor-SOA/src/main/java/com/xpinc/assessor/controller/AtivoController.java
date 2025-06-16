package com.xpinc.assessor.controller;

import com.xpinc.assessor.domain.Ativo;
import com.xpinc.assessor.dto.AtivoDTO;
import com.xpinc.assessor.service.AtivoService;
import com.xpinc.assessor.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ativos")
public class AtivoController {
    private final AtivoService service;
    public AtivoController(AtivoService service) { this.service = service; }

    @GetMapping
    public List<AtivoDTO> listar() {
        return service.findAll().stream()
            .map(a -> new AtivoDTO(a.getId(), a.getNome(), a.getClasse(), a.getRetornoHistorico(), a.getLiquidezDias()))
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtivoDTO> buscar(@PathVariable Long id) {
        return service.findById(id)
            .map(a -> ResponseEntity.ok(new AtivoDTO(a.getId(), a.getNome(), a.getClasse(), a.getRetornoHistorico(), a.getLiquidezDias())))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtivoDTO> criar(@RequestBody AtivoDTO dto) {
        Ativo a = service.save(new Ativo(null, dto.getNome(), dto.getClasse(), dto.getRetornoHistorico(), dto.getLiquidezDias()));
        URI uri = URI.create("/api/ativos/" + a.getId());
        return ResponseEntity.created(uri).body(new AtivoDTO(a.getId(), a.getNome(), a.getClasse(), a.getRetornoHistorico(), a.getLiquidezDias()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtivoDTO> atualizar(@PathVariable Long id, @RequestBody AtivoDTO dto) {
        if (!service.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Ativo não encontrado");
        }
        Ativo a = new Ativo(id, dto.getNome(), dto.getClasse(), dto.getRetornoHistorico(), dto.getLiquidezDias());
        service.save(a);
        return ResponseEntity.ok(new AtivoDTO(a.getId(), a.getNome(), a.getClasse(), a.getRetornoHistorico(), a.getLiquidezDias()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}