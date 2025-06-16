package com.xpinc.assessor.dto;

import java.util.Map;

public class RecomendacaoResponse {
    private Map<String, Double> alocacao;
    private String explicacao;
    public RecomendacaoResponse() {}
    public RecomendacaoResponse(Map<String, Double> alocacao, String explicacao) {
        this.alocacao = alocacao; this.explicacao = explicacao;
    }
    public Map<String, Double> getAlocacao() { return alocacao; }
    public void setAlocacao(Map<String, Double> alocacao) { this.alocacao = alocacao; }
    public String getExplicacao() { return explicacao; }
    public void setExplicacao(String explicacao) { this.explicacao = explicacao; }
}