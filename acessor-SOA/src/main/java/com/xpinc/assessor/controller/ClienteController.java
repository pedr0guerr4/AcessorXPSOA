package com.xpinc.assessor.controller;

import com.xpinc.assessor.dto.ClienteDTO;
import com.xpinc.assessor.service.ClienteService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Validated
public class ClienteController {
	private final ClienteService service;

	public ClienteController(ClienteService service) {
		this.service = service;
	}

	@GetMapping
	public List<ClienteDTO> listar() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> buscar(@PathVariable @Positive Long id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> criar(@Valid @RequestBody ClienteDTO dto) {
		var saved = service.criar(dto);
		return ResponseEntity.created(URI.create("/api/clientes/" + saved.getId())).body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable @Positive Long id, @Valid @RequestBody ClienteDTO dto) {
		var updated = service.atualizar(id, dto);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable @Positive Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}