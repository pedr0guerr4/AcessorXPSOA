package com.xpinc.assessor.mapper;

import com.xpinc.assessor.domain.VariaveisMacro;
import com.xpinc.assessor.dto.VariaveisMacroDTO;

public final class VariaveisMacroMapper {
	private VariaveisMacroMapper() {
	}

	public static VariaveisMacroDTO toDTO(VariaveisMacro v) {
		return new VariaveisMacroDTO(v.getId(), v.getTaxaJuros(), v.getCambio(), v.getTributos());
	}

	public static VariaveisMacro toEntity(VariaveisMacroDTO d) {
		VariaveisMacro v = new VariaveisMacro();
		v.setId(d.getId());
		v.setTaxaJuros(d.getTaxaJuros());
		v.setCambio(d.getCambio());
		v.setTributos(d.getTributos());
		return v;
	}

	public static void copy(VariaveisMacroDTO d, VariaveisMacro v) {
		v.setTaxaJuros(d.getTaxaJuros());
		v.setCambio(d.getCambio());
		v.setTributos(d.getTributos());
	}
}
