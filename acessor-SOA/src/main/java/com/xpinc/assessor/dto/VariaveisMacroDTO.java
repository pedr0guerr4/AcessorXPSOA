package com.xpinc.assessor.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class VariaveisMacroDTO {
	private Long id;

	@NotNull
	@Digits(integer = 8, fraction = 2)
	private BigDecimal taxaJuros;

	@NotNull
	@Digits(integer = 8, fraction = 2)
	private BigDecimal cambio;

	@NotNull
	@Digits(integer = 8, fraction = 2)
	private BigDecimal tributos;

	public VariaveisMacroDTO() {
	}

	public VariaveisMacroDTO(Long id, BigDecimal taxaJuros, BigDecimal cambio, BigDecimal tributos) {
		this.id = id;
		this.taxaJuros = taxaJuros;
		this.cambio = cambio;
		this.tributos = tributos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(BigDecimal v) {
		this.taxaJuros = v;
	}

	public BigDecimal getCambio() {
		return cambio;
	}

	public void setCambio(BigDecimal v) {
		this.cambio = v;
	}

	public BigDecimal getTributos() {
		return tributos;
	}

	public void setTributos(BigDecimal v) {
		this.tributos = v;
	}
}
