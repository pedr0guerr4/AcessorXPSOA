package com.xpinc.assessor.domain;

public class VariaveisMacro {
    private Long id;
    private double taxaJuros;
    private double cambio;
    private double tributos;

    public VariaveisMacro() {}
    public VariaveisMacro(Long id, double taxaJuros, double cambio, double tributos) {
        this.id = id; this.taxaJuros = taxaJuros; this.cambio = cambio; this.tributos = tributos;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public double getTaxaJuros() { return taxaJuros; }
    public void setTaxaJuros(double taxaJuros) { this.taxaJuros = taxaJuros; }
    public double getCambio() { return cambio; }
    public void setCambio(double cambio) { this.cambio = cambio; }
    public double getTributos() { return tributos; }
    public void setTributos(double tributos) { this.tributos = tributos; }
}