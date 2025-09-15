package com.xpinc.assessor.infrastructure.jpa;

import com.xpinc.assessor.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<Cliente, Long> {
	
}