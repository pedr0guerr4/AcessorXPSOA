package com.xpinc.assessor.domain.model;

import com.xpinc.assessor.domain.model.enums.*;
import jakarta.persistence.*;

@Entity
public class Objetivo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long clienteId;
	@Enumerated(EnumType.STRING)
	private ObjetivoPrazo prazo;
	private Long valorAlvoCentavos;
	private int prazoMeses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public ObjetivoPrazo getPrazo() {
		return prazo;
	}

	public void setPrazo(ObjetivoPrazo prazo) {
		this.prazo = prazo;
	}

	public Long getValorAlvoCentavos() {
		return valorAlvoCentavos;
	}

	public void setValorAlvoCentavos(Long valorAlvoCentavos) {
		this.valorAlvoCentavos = valorAlvoCentavos;
	}

	public int getPrazoMeses() {
		return prazoMeses;
	}

	public void setPrazoMeses(int prazoMeses) {
		this.prazoMeses = prazoMeses;
	}

}