package com.xpinc.assessor.dto;

public class RecomendacaoRequest {
    private Long clienteId;
    public RecomendacaoRequest() {}
    public RecomendacaoRequest(Long clienteId) { this.clienteId = clienteId; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}