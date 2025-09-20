package com.xpinc.assessor.service.strategy;

import org.springframework.stereotype.Component;

import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.domain.Cliente;
import com.xpinc.assessor.domain.PerfilInvestidor;

@Component
public class ModeradoStrategy implements Strategy {
	public PerfilInvestidor perfil() {
		return PerfilInvestidor.MODERADO;
	}

	public Carteira recomendar(Cliente cliente) {
		return Carteira.moderadaPadrao();
	}
}
