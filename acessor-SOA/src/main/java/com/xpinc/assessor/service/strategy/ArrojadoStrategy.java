package com.xpinc.assessor.service.strategy;

import org.springframework.stereotype.Component;

import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.domain.Cliente;
import com.xpinc.assessor.domain.PerfilInvestidor;

@Component
public class ArrojadoStrategy implements Strategy {
	@Override
	public PerfilInvestidor perfil() {
		return PerfilInvestidor.ARROJADO;
	}

	@Override
	public Carteira recomendar(Cliente cliente) {
		return Carteira.arrojadaPadrao();
	}
}
