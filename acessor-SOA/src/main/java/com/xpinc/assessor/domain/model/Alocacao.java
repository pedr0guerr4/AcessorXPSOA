package com.xpinc.assessor.domain.model;

import jakarta.persistence.*;

@Entity
public class Alocacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long carteiraId;
	private Long ativoId;
	private int percentual; // 0..100

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCarteiraId() {
		return carteiraId;
	}

	public void setCarteiraId(Long carteiraId) {
		this.carteiraId = carteiraId;
	}

	public Long getAtivoId() {
		return ativoId;
	}

	public void setAtivoId(Long ativoId) {
		this.ativoId = ativoId;
	}

	public int getPercentual() {
		return percentual;
	}

	public void setPercentual(int percentual) {
		this.percentual = percentual;
	}

}