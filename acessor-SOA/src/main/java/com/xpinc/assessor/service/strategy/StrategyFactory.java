package com.xpinc.assessor.service.strategy;

import org.springframework.stereotype.Component;

import com.xpinc.assessor.domain.PerfilInvestidor;

@Component
public class StrategyFactory {
	private final java.util.Map<PerfilInvestidor, Strategy> byPerfil;

	public StrategyFactory(java.util.List<Strategy> strategies) {
		var m = new java.util.EnumMap<PerfilInvestidor, Strategy>(PerfilInvestidor.class);
		for (Strategy s : strategies)
			m.put(s.perfil(), s);
		this.byPerfil = java.util.Collections.unmodifiableMap(m);
	}

	public Strategy getStrategy(PerfilInvestidor perfil) {
		var s = byPerfil.get(perfil);
		if (s == null)
			throw new IllegalArgumentException("Perfil sem estratégia: " + perfil);
		return s;
	}
}
