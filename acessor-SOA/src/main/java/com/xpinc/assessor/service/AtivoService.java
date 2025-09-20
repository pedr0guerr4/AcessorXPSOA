package com.xpinc.assessor.service;

import com.xpinc.assessor.dto.AtivoDTO;
import com.xpinc.assessor.mapper.AtivoMapper;
import com.xpinc.assessor.repository.AtivoRepository;
import com.xpinc.assessor.exception.ResourceNotFoundException;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtivoService {
	private final AtivoRepository repo;

	public AtivoService(AtivoRepository repo) {
		this.repo = repo;
	}

	@Transactional
	public AtivoDTO criar(@Valid AtivoDTO dto) {
		var saved = repo.save(AtivoMapper.toEntity(dto));
		return AtivoMapper.toDTO(saved);
	}

	@Transactional(readOnly = true)
	public AtivoDTO buscar(Long id) {
		var a = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ativo não encontrado"));
		return AtivoMapper.toDTO(a);
	}

	@Transactional(readOnly = true)
	public Page<AtivoDTO> listar(Pageable pageable) {
	    return repo.findAll(pageable).map(AtivoMapper::toDTO);
	}

	@Transactional
	public AtivoDTO atualizar(Long id, @Valid AtivoDTO dto) {
		var a = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ativo não encontrado"));
		a.setNome(dto.getNome());
		a.setClasse(dto.getClasse());
		a.setRetornoHistorico(dto.getRetornoHistorico());
		a.setLiquidezDias(dto.getLiquidezDias());
		return AtivoMapper.toDTO(repo.save(a));
	}

	@Transactional
	public void deletar(Long id) {
		repo.deleteById(id);
	}
}
