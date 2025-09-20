package com.xpinc.assessor.mapper;

import com.xpinc.assessor.domain.Ativo;
import com.xpinc.assessor.dto.AtivoDTO;

public final class AtivoMapper {
	private AtivoMapper() {
	}

	public static AtivoDTO toDTO(Ativo a) {
		return new AtivoDTO(a.getId(), a.getNome(), a.getClasse(), a.getRetornoHistorico(), a.getLiquidezDias());
	}

	public static Ativo toEntity(AtivoDTO d) {
		Ativo a = new Ativo();
		a.setId(d.getId());
		a.setNome(d.getNome());
		a.setClasse(d.getClasse());
		a.setRetornoHistorico(d.getRetornoHistorico());
		a.setLiquidezDias(d.getLiquidezDias());
		return a;
	}
}
