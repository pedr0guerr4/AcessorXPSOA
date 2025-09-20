package com.xpinc.assessor.service;

import static com.xpinc.assessor.mapper.VariaveisMacroMapper.copy;
import static com.xpinc.assessor.mapper.VariaveisMacroMapper.toEntity;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpinc.assessor.domain.VariaveisMacro;
import com.xpinc.assessor.dto.VariaveisMacroDTO;
import com.xpinc.assessor.exception.ResourceNotFoundException;
import com.xpinc.assessor.repository.VariaveisMacroRepository;

@Service
public class VariaveisMacroService {
	private final VariaveisMacroRepository repo;

	public VariaveisMacroService(VariaveisMacroRepository repo) {
		this.repo = repo;
	}

	@Transactional(readOnly = true)
	public List<VariaveisMacro> findAll() {
		return repo.findAll();
	}

	@Transactional(readOnly = true)
	public java.util.Optional<VariaveisMacro> findById(Long id) {
		return repo.findById(id);
	}

	@Transactional
	public VariaveisMacro save(VariaveisMacroDTO dto) {
		return repo.save(toEntity(dto));
	}

	@Transactional
	public VariaveisMacro update(Long id, VariaveisMacroDTO dto) {
		VariaveisMacro v = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Variáveis Macro não encontrado"));
		copy(dto, v);
		return repo.save(v);
	}

	@Transactional
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
