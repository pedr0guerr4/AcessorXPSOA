package com.xpinc.assessor.mapper;

import com.xpinc.assessor.domain.Cliente;
import com.xpinc.assessor.dto.ClienteDTO;

public final class ClienteMapper {
	private ClienteMapper() {
	}

	public static ClienteDTO toDTO(Cliente c) {
		return new ClienteDTO(c.getId(), c.getNome(), c.getCpf(), c.getPerfilInvestidor());
	}

	public static Cliente toEntity(ClienteDTO d) {
		var c = new Cliente();
		c.setId(d.getId());
		c.setNome(d.getNome());
		c.setCpf(d.getCpf());
		c.setPerfilInvestidor(d.getPerfil());
		return c;
	}
}