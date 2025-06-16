package com.xpinc.assessor.domain;

public class Cliente {
    private Long id;
    private String nome;
    private PerfilInvestidor perfil;
    private double liquidezDisponivel;
    private String objetivos;

    public Cliente() {}
    public Cliente(Long id, String nome, PerfilInvestidor perfil, double liquidezDisponivel, String objetivos) {
        this.id = id; this.nome = nome; this.perfil = perfil;
        this.liquidezDisponivel = liquidezDisponivel; this.objetivos = objetivos;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public PerfilInvestidor getPerfil() { return perfil; }
    public void setPerfil(PerfilInvestidor perfil) { this.perfil = perfil; }
    public double getLiquidezDisponivel() { return liquidezDisponivel; }
    public void setLiquidezDisponivel(double liquidezDisponivel) { this.liquidezDisponivel = liquidezDisponivel; }
    public String getObjetivos() { return objetivos; }
    public void setObjetivos(String objetivos) { this.objetivos = objetivos; }
}