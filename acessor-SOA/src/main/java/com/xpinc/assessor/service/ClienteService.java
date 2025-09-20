package com.xpinc.assessor.service;

import com.xpinc.assessor.domain.Cliente;
import com.xpinc.assessor.dto.ClienteDTO;
import com.xpinc.assessor.exception.ResourceNotFoundException;
import com.xpinc.assessor.mapper.ClienteMapper;
import com.xpinc.assessor.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

	private final ClienteRepository repo;

	public ClienteService(ClienteRepository repo) {
		this.repo = repo;
	}

	@Transactional
	public ClienteDTO criar(ClienteDTO dto) {
		var saved = repo.save(ClienteMapper.toEntity(dto));
		return ClienteMapper.toDTO(saved);
	}

	@Transactional(readOnly = true)
	public Optional<ClienteDTO> findById(Long id) {
		return repo.findById(id).map(ClienteMapper::toDTO);
	}

	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {
		return repo.findAll().stream().map(ClienteMapper::toDTO).toList();
	}

	@Transactional
	public ClienteDTO atualizar(Long id, ClienteDTO dto) {
		var c = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
		c.setNome(dto.getNome());
		c.setCpf(dto.getCpf());
		c.setPerfilInvestidor(dto.getPerfil());
		return ClienteMapper.toDTO(repo.save(c));
	}

	@Transactional
	public void delete(Long id) {
		repo.deleteById(id);
	}

	// ==== MÉTODO QUE FALTAVA (usado pela recomendação) ====
	@Transactional(readOnly = true)
	public Cliente findEntityOrThrow(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
	}
}
