package com.xpinc.assessor.domain;

import java.util.*;

public class Carteira {
	private final PerfilInvestidor risco;
	private final List<Alocacao> alocacoes;

	public Carteira(PerfilInvestidor risco, List<Alocacao> alocacoes) {
		this.risco = Objects.requireNonNull(risco);
		this.alocacoes = Collections.unmodifiableList(new ArrayList<>(alocacoes));
	}

	public PerfilInvestidor getRisco() {
		return risco;
	}

	public List<Alocacao> getAlocacoes() {
		return alocacoes;
	}

	public static Carteira conservadoraPadrao() {
		List<Alocacao> a = new ArrayList<>();
		a.add(new Alocacao(ClasseAtivo.RENDA_FIXA, 70.0));
		a.add(new Alocacao(ClasseAtivo.RENDA_VARIAVEL, 10.0));
		a.add(new Alocacao(ClasseAtivo.MULTIMERCADO, 10.0));
		a.add(new Alocacao(ClasseAtivo.CAMBIAL, 10.0));
		return new Carteira(PerfilInvestidor.CONSERVADOR, a);
	}

	public static Carteira moderadaPadrao() {
		List<Alocacao> a = new ArrayList<>();
		a.add(new Alocacao(ClasseAtivo.RENDA_FIXA, 50.0));
		a.add(new Alocacao(ClasseAtivo.RENDA_VARIAVEL, 25.0));
		a.add(new Alocacao(ClasseAtivo.MULTIMERCADO, 15.0));
		a.add(new Alocacao(ClasseAtivo.CAMBIAL, 10.0));
		return new Carteira(PerfilInvestidor.MODERADO, a);
	}

	public static Carteira arrojadaPadrao() {
		List<Alocacao> a = new ArrayList<>();
		a.add(new Alocacao(ClasseAtivo.RENDA_FIXA, 20.0));
		a.add(new Alocacao(ClasseAtivo.RENDA_VARIAVEL, 50.0));
		a.add(new Alocacao(ClasseAtivo.MULTIMERCADO, 20.0));
		a.add(new Alocacao(ClasseAtivo.CAMBIAL, 10.0));
		return new Carteira(PerfilInvestidor.ARROJADO, a);
	}
}
