package com.xpinc.assessor.util;

import org.springframework.stereotype.Component;
import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.dto.ClienteDTO;

@Component
public class XAIUtil {
    public String gerarExplicacao(Carteira carteira, ClienteDTO clienteDTO) {
        return "Explicação para cliente " + clienteDTO.getNome();
    }
}