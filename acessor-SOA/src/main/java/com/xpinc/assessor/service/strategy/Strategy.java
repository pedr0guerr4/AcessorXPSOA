package com.xpinc.assessor.service.strategy;

import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.domain.PerfilInvestidor;

public interface Strategy {
	PerfilInvestidor perfil();

	Carteira recomendar(com.xpinc.assessor.domain.Cliente cliente);
}
