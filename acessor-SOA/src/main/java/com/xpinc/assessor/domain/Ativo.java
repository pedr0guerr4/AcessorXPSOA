package com.xpinc.assessor.domain;

public class Ativo {
    private Long id;
    private String nome;
    private ClasseAtivo classe;
    private double retornoHistorico;
    private int liquidezDias;

    public Ativo() {}
    public Ativo(Long id, String nome, ClasseAtivo classe, double retornoHistorico, int liquidezDias) {
        this.id = id; this.nome = nome; this.classe = classe;
        this.retornoHistorico = retornoHistorico; this.liquidezDias = liquidezDias;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public ClasseAtivo getClasse() { return classe; }
    public void setClasse(ClasseAtivo classe) { this.classe = classe; }
    public double getRetornoHistorico() { return retornoHistorico; }
    public void setRetornoHistorico(double retornoHistorico) { this.retornoHistorico = retornoHistorico; }
    public int getLiquidezDias() { return liquidezDias; }
    public void setLiquidezDias(int liquidezDias) { this.liquidezDias = liquidezDias; }
}