package com.xpinc.assessor.service.strategy;

import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.domain.Cliente;

public interface RecomendacaoStrategy {
    Carteira recomendar(Cliente cliente);
}