package com.xpinc.assessor.service.strategy;

import org.springframework.stereotype.Component;

import com.xpinc.assessor.domain.model.Carteira;
import com.xpinc.assessor.domain.model.Cliente;

import java.util.Collections;
@Component
public class ModeradoStrategy implements RecomendacaoStrategy {
    @Override
    public Carteira recomendar(Cliente cliente) {
        return new Carteira(Collections.emptyMap());
    }
}