package com.xpinc.assessor.service.strategy;

import com.xpinc.assessor.domain.model.Carteira;
import com.xpinc.assessor.domain.model.Cliente;

public interface RecomendacaoStrategy {
    Carteira recomendar(Cliente cliente);
}