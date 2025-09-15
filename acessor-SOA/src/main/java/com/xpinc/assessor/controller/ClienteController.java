package com.xpinc.assessor.controller;

import com.xpinc.assessor.domain.model.Cliente;
import com.xpinc.assessor.dto.ClienteDTO;
import com.xpinc.assessor.service.ClienteService;
import com.xpinc.assessor.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;
    public ClienteController(ClienteService service) { this.service = service; }

    @GetMapping
    public List<ClienteDTO> listar() {
        return service.findAll().stream()
            .map(c -> new ClienteDTO(c.getId(), c.getNome(), c.getPerfil(), c.getLiquidezDisponivel(), c.getObjetivos()))
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) {
        return service.findById(id)
            .map(c -> ResponseEntity.ok(new ClienteDTO(c.getId(), c.getNome(), c.getPerfil(), c.getLiquidezDisponivel(), c.getObjetivos())))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO dto) {
        Cliente c = service.save(new Cliente(null, dto.getNome(), dto.getPerfil(), dto.getLiquidezDisponivel(), dto.getObjetivos()));
        URI uri = URI.create("/api/clientes/" + c.getId());
        return ResponseEntity.created(uri).body(new ClienteDTO(c.getId(), c.getNome(), c.getPerfil(), c.getLiquidezDisponivel(), c.getObjetivos()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        if (!service.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        Cliente c = new Cliente(id, dto.getNome(), dto.getPerfil(), dto.getLiquidezDisponivel(), dto.getObjetivos());
        service.save(c);
        return ResponseEntity.ok(new ClienteDTO(c.getId(), c.getNome(), c.getPerfil(), c.getLiquidezDisponivel(), c.getObjetivos()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}