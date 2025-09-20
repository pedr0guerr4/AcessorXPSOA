package com.xpinc.assessor.service.strategy;

import com.xpinc.assessor.domain.*;
import org.springframework.stereotype.Component;

@Component
public class ConservadorStrategy implements Strategy {
	@Override
	public PerfilInvestidor perfil() {
		return PerfilInvestidor.CONSERVADOR;
	}

	@Override
	public Carteira recomendar(Cliente cliente) {
		// TODO: regra real; dummy de exemplo:
		return Carteira.conservadoraPadrao();
	}
}
