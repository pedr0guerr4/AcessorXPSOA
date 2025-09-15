package com.xpinc.assessor.controller;

import com.xpinc.assessor.domain.model.VariaveisMacro;
import com.xpinc.assessor.dto.VariaveisMacroDTO;
import com.xpinc.assessor.service.VariaveisMacroService;
import com.xpinc.assessor.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/variaveis-macro")
public class VariaveisMacroController {
    private final VariaveisMacroService service;
    public VariaveisMacroController(VariaveisMacroService service) { this.service = service; }

    @GetMapping
    public List<VariaveisMacroDTO> listar() {
        return service.findAll().stream()
            .map(v -> new VariaveisMacroDTO(v.getId(), v.getTaxaJuros(), v.getCambio(), v.getTributos()))
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VariaveisMacroDTO> buscar(@PathVariable Long id) {
        return service.findById(id)
            .map(v -> ResponseEntity.ok(new VariaveisMacroDTO(v.getId(), v.getTaxaJuros(), v.getCambio(), v.getTributos())))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VariaveisMacroDTO> criar(@RequestBody VariaveisMacroDTO dto) {
        VariaveisMacro v = service.save(new VariaveisMacro(null, dto.getTaxaJuros(), dto.getCambio(), dto.getTributos()));
        URI uri = URI.create("/api/variaveis-macro/" + v.getId());
        return ResponseEntity.created(uri).body(new VariaveisMacroDTO(v.getId(), v.getTaxaJuros(), v.getCambio(), v.getTributos()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VariaveisMacroDTO> atualizar(@PathVariable Long id, @RequestBody VariaveisMacroDTO dto) {
        if (!service.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Variáveis Macro não encontrado");
        }
        VariaveisMacro v = new VariaveisMacro(id, dto.getTaxaJuros(), dto.getCambio(), dto.getTributos());
        service.save(v);
        return ResponseEntity.ok(new VariaveisMacroDTO(v.getId(), v.getTaxaJuros(), v.getCambio(), v.getTributos()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}