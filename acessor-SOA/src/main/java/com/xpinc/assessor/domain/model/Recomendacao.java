package com.xpinc.assessor.domain.model;

import java.time.LocalDateTime;

public class Recomendacao {
    private Long id;
    private Cliente cliente;
    private Carteira carteira;
    private String explicacao;
    private LocalDateTime dataGeracao;

    public Recomendacao() {}
    public Recomendacao(Long id, Cliente cliente, Carteira carteira, String explicacao, LocalDateTime dataGeracao) {
        this.id = id; this.cliente = cliente; this.carteira = carteira;
        this.explicacao = explicacao; this.dataGeracao = dataGeracao;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Carteira getCarteira() { return carteira; }
    public void setCarteira(Carteira carteira) { this.carteira = carteira; }
    public String getExplicacao() { return explicacao; }
    public void setExplicacao(String explicacao) { this.explicacao = explicacao; }
    public LocalDateTime getDataGeracao() { return dataGeracao; }
    public void setDataGeracao(LocalDateTime dataGeracao) { this.dataGeracao = dataGeracao; }
}