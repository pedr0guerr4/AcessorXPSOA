package com.xpinc.assessor.service.strategy;

import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.domain.Cliente;
import org.springframework.stereotype.Component;

import java.util.Collections;
@Component
public class ConservadorStrategy implements RecomendacaoStrategy {
    @Override
    public Carteira recomendar(Cliente cliente) {
        // 100% renda fixa, ex.
        return new Carteira(Collections.emptyMap());
    }
}