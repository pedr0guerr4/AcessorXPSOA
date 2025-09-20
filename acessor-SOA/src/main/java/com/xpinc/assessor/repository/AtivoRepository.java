package com.xpinc.assessor.repository;

import com.xpinc.assessor.domain.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AtivoRepository extends JpaRepository<Ativo, Long> {
	Page<Ativo> findAll(Pageable pageable); 
}