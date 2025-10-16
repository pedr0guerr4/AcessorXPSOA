package com.xpinc.assessor.controller;

import com.xpinc.assessor.dto.AtivoDTO;
import com.xpinc.assessor.service.AtivoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Ativos", description = "CRUD de Ativos")
@RestController
@RequestMapping("/api/ativos")
@PreAuthorize("hasRole('USER')")
public class AtivoController {

	private final AtivoService service;

	public AtivoController(AtivoService service) {
		this.service = service;
	}

	@Operation(summary = "Cria um ativo")
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<AtivoDTO> create(@Valid @RequestBody AtivoDTO dto) {
		AtivoDTO saved = service.criar(dto);
		return ResponseEntity.created(URI.create("/api/ativos/" + saved.getId())).body(saved);
	}

	@Operation(summary = "Lista todos os ativos")
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Page<AtivoDTO>> list(@PageableDefault(size = 20, sort = "id") Pageable pageable) {
		return ResponseEntity.ok(service.listar(pageable));
	}

	@Operation(summary = "Busca ativo por ID")
	@GetMapping("/{id}")
	public AtivoDTO byId(@PathVariable @Positive Long id) {
		return service.buscar(id);
	}

	@Operation(summary = "Atualiza um ativo pelo ID")
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public AtivoDTO update(@PathVariable Long id, @Valid @RequestBody AtivoDTO dto) {
		return service.atualizar(id, dto);
	}

	@Operation(summary = "Remove um ativo pelo ID")
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
