package com.xpinc.assessor.infrastructure.jpa;

import com.xpinc.assessor.domain.model.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtivoJpaRepository extends JpaRepository<Ativo, Long> {
	
}