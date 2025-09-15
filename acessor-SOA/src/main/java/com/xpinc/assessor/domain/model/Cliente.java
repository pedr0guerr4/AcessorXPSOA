package com.xpinc.assessor.domain.model;

import com.xpinc.assessor.domain.model.enums.PerfilSuitability;
import jakarta.persistence.*;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	private PerfilSuitability perfil;
	private Long liquidezDisponivelCentavos;
	private String currency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PerfilSuitability getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilSuitability perfil) {
		this.perfil = perfil;
	}

	public Long getLiquidezDisponivelCentavos() {
		return liquidezDisponivelCentavos;
	}

	public void setLiquidezDisponivelCentavos(Long liquidezDisponivelCentavos) {
		this.liquidezDisponivelCentavos = liquidezDisponivelCentavos;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}