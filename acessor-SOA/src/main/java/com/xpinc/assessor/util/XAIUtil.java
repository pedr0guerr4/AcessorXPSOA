package com.xpinc.assessor.util;

import org.springframework.stereotype.Component;

import com.xpinc.assessor.domain.model.Carteira;
import com.xpinc.assessor.domain.model.Cliente;

@Component
public class XAIUtil {
    public String gerarExplicacao(Carteira carteira, Cliente cliente) {
        return "Explicação para cliente " + cliente.getNome();
    }
}