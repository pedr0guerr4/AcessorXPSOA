package com.xpinc.assessor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.domain.Cliente;
import com.xpinc.assessor.dto.AlocacaoDTO;
import com.xpinc.assessor.dto.ClienteDTO;
import com.xpinc.assessor.dto.RecomendacaoRequest;
import com.xpinc.assessor.dto.RecomendacaoResponse;
import com.xpinc.assessor.mapper.ClienteMapper;
import com.xpinc.assessor.service.strategy.Strategy;
import com.xpinc.assessor.service.strategy.StrategyFactory;
import com.xpinc.assessor.util.XAIUtil;

@Service
public class RecomendacaoService {

	private final ClienteService clienteService;
	private final StrategyFactory strategyFactory;
	private final XAIUtil xaiUtil;

	public RecomendacaoService(ClienteService clienteService, StrategyFactory strategyFactory, XAIUtil xaiUtil) {
		this.clienteService = clienteService;
		this.strategyFactory = strategyFactory;
		this.xaiUtil = xaiUtil;
	}

	public RecomendacaoResponse gerar(RecomendacaoRequest req) {
		Cliente cliente = clienteService.findEntityOrThrow(req.getClienteId());

		var perfil = cliente.getPerfilInvestidor(); 
		Strategy strat = strategyFactory.getStrategy(perfil);
		Carteira carteira = strat.recomendar(cliente);

		ClienteDTO clienteDTO = ClienteMapper.toDTO(cliente);
		String explicacao = xaiUtil.gerarExplicacao(carteira, clienteDTO);

		List<AlocacaoDTO> aloc = carteira.getAlocacoes().stream().map(AlocacaoDTO::of).collect(Collectors.toList());

		return new RecomendacaoResponse(carteira.getRisco(), aloc, explicacao);
	}
}
