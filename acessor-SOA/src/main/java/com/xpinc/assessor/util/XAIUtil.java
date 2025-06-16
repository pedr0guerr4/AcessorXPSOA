package com.xpinc.assessor.util;

import org.springframework.stereotype.Component;
import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.domain.Cliente;

@Component
public class XAIUtil {
    public String gerarExplicacao(Carteira carteira, Cliente cliente) {
        return "Explicação para cliente " + cliente.getNome();
    }
}