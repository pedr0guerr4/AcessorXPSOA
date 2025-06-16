package com.xpinc.assessor.domain;

import java.util.Map;

public class Carteira {
    private Map<Ativo, Double> alocacao;
    public Carteira() {}
    public Carteira(Map<Ativo, Double> alocacao) { this.alocacao = alocacao; }
    public Map<Ativo, Double> getAlocacao() { return alocacao; }
    public void setAlocacao(Map<Ativo, Double> alocacao) { this.alocacao = alocacao; }
}