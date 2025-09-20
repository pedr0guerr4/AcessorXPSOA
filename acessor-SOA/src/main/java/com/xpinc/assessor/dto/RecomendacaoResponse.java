package com.xpinc.assessor.dto;

import com.xpinc.assessor.domain.PerfilInvestidor;
import java.util.List;

public class RecomendacaoResponse {
	private PerfilInvestidor risco;
	private java.util.List<AlocacaoDTO> alocacao;
	private String explicacao;

	public RecomendacaoResponse(PerfilInvestidor risco, java.util.List<AlocacaoDTO> alocacao, String explicacao) {
		this.risco = risco;
		this.alocacao = alocacao;
		this.explicacao = explicacao;
	}

	public PerfilInvestidor getRisco() {
		return risco;
	}

	public List<AlocacaoDTO> getAlocacao() {
		return alocacao;
	}

	public String getExplicacao() {
		return explicacao;
	}
}
