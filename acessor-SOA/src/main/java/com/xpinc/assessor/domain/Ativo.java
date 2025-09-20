package com.xpinc.assessor.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ativos")
public class Ativo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 120)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private ClasseAtivo classe;

	@Column(name = "retorno_historico", nullable = false)
	private double retornoHistorico;

	@Column(name = "liquidez_dias", nullable = false)
	private int liquidezDias;

	public Ativo() {
	}

	// GETTERS
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public ClasseAtivo getClasse() {
		return classe;
	}

	public double getRetornoHistorico() {
		return retornoHistorico;
	}

	public int getLiquidezDias() {
		return liquidezDias;
	}

	// SETTERS
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setClasse(ClasseAtivo classe) {
		this.classe = classe;
	}

	public void setRetornoHistorico(double retornoHistorico) {
		this.retornoHistorico = retornoHistorico;
	}

	public void setLiquidezDias(int liquidezDias) {
		this.liquidezDias = liquidezDias;
	}
}
