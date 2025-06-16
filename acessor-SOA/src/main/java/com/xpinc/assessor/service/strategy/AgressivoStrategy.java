package com.xpinc.assessor.service.strategy;

import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.domain.Cliente;
import org.springframework.stereotype.Component;

import java.util.Collections;
@Component
public class AgressivoStrategy implements RecomendacaoStrategy {
    @Override
    public Carteira recomendar(Cliente cliente) {
        return new Carteira(Collections.emptyMap());
    }
}