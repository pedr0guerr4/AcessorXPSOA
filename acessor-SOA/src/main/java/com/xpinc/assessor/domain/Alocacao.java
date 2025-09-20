package com.xpinc.assessor.domain;

public class Alocacao {
	private ClasseAtivo classe;
	private double percentual;

	public Alocacao() {
	}

	public Alocacao(ClasseAtivo classe, double percentual) {
		this.classe = classe;
		this.percentual = percentual;
	}

	public ClasseAtivo getClasse() {
		return classe;
	}

	public void setClasse(ClasseAtivo c) {
		this.classe = c;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double p) {
		this.percentual = p;
	}
}
