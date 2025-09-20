package com.xpinc.assessor.dto;

import com.xpinc.assessor.domain.PerfilInvestidor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteDTO {
	private Long id;
	@NotBlank
	@Size(max = 120)
	private String nome;
	@NotBlank
	@Size(max = 14)
	private String cpf;
	@NotNull
	private PerfilInvestidor perfil;

	public ClienteDTO() {
	}

	public ClienteDTO(Long id, String nome, String cpf, PerfilInvestidor perfil) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.perfil = perfil;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PerfilInvestidor getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilInvestidor perfil) {
		this.perfil = perfil;
	}

}