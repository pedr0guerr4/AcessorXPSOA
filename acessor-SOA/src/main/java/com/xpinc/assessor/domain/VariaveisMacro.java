package com.xpinc.assessor.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "variaveis_macro")
public class VariaveisMacro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "taxa_juros", nullable = false, precision = 10, scale = 2)
	private BigDecimal taxaJuros;

	@Column(name = "cambio", nullable = false, precision = 10, scale = 2)
	private BigDecimal cambio;

	@Column(name = "tributos", nullable = false, precision = 10, scale = 2)
	private BigDecimal tributos;

	public VariaveisMacro() {
	}

	// Opcional: se quiser manter a construção direta
	public VariaveisMacro(Long id, BigDecimal taxaJuros, BigDecimal cambio, BigDecimal tributos) {
		this.id = id;
		this.taxaJuros = taxaJuros;
		this.cambio = cambio;
		this.tributos = tributos;
	}

	// getters/setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(BigDecimal taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public BigDecimal getCambio() {
		return cambio;
	}

	public void setCambio(BigDecimal cambio) {
		this.cambio = cambio;
	}

	public BigDecimal getTributos() {
		return tributos;
	}

	public void setTributos(BigDecimal tributos) {
		this.tributos = tributos;
	}
}
