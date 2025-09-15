package com.xpinc.assessor.service;

import com.xpinc.assessor.application.ports.*;
import com.xpinc.assessor.domain.model.*;
import com.xpinc.assessor.domain.model.enums.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RecomendacaoService {
	private final AtivoRepositoryPort ativoRepo;
	private final CarteiraRepositoryPort carteiraRepo;

	public RecomendacaoService(AtivoRepositoryPort ativoRepo, CarteiraRepositoryPort carteiraRepo) {
		this.ativoRepo = ativoRepo;
		this.carteiraRepo = carteiraRepo;
	}

	public List<Carteira> recomendar(PerfilSuitability perfil, ObjetivoPrazo prazo) {
// MVP simples: 3 carteiras
		var ativos = ativoRepo.findAll();
// Monte alocações dummy só para prova de conceito
		List<Carteira> saida = new ArrayList<>();
		for (String tipo : List.of("conservadora", "balanceada", "arrojada")) {
			var c = new Carteira();
			c.setClienteId(1L);
			c.setDataRef(java.time.LocalDate.now().toString());
			c = carteiraRepo.save(c);
// alocação 60/30/10 etc. (omisso)
			saida.add(c);
		}
		return saida;
	}
}