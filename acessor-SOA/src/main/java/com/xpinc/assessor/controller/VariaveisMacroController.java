package com.xpinc.assessor.controller;

import com.xpinc.assessor.dto.VariaveisMacroDTO;
import com.xpinc.assessor.service.VariaveisMacroService;
import com.xpinc.assessor.mapper.VariaveisMacroMapper;
import com.xpinc.assessor.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("/api/variaveis-macro")
public class VariaveisMacroController {

	private final VariaveisMacroService service;

	public VariaveisMacroController(VariaveisMacroService service) {
		this.service = service;
	}

	@GetMapping
	public List<VariaveisMacroDTO> listar() {
		return service.findAll().stream().map(VariaveisMacroMapper::toDTO).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<VariaveisMacroDTO> buscar(@PathVariable Long id) {
		return service.findById(id).map(v -> ResponseEntity.ok(VariaveisMacroMapper.toDTO(v)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<VariaveisMacroDTO> criar(@Valid @RequestBody VariaveisMacroDTO dto) {
		var v = service.save(dto);
		var body = VariaveisMacroMapper.toDTO(v);
		return ResponseEntity.created(URI.create("/api/variaveis-macro/" + v.getId())).body(body);
	}

	@PutMapping("/{id}")
	public ResponseEntity<VariaveisMacroDTO> atualizar(@PathVariable Long id,
			@Valid @RequestBody VariaveisMacroDTO dto) {
		if (service.findById(id).isEmpty())
			throw new ResourceNotFoundException("Variáveis Macro não encontrado");

		var v = service.update(id, dto);
		return ResponseEntity.ok(VariaveisMacroMapper.toDTO(v));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
