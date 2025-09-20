package com.xpinc.assessor.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 120)
	private String nome;

	@Column(nullable = false, unique = true, length = 14)
	private String cpf;

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false, length = 20) // <-- AQUI: bater com a coluna existente
	private PerfilInvestidor perfilInvestidor;

	public Cliente() {
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

	public PerfilInvestidor getPerfilInvestidor() {
		return perfilInvestidor;
	}

	public void setPerfilInvestidor(PerfilInvestidor perfilInvestidor) {
		this.perfilInvestidor = perfilInvestidor;
	}
}
