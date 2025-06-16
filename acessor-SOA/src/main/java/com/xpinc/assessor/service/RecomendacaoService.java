package com.xpinc.assessor.service;

import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.dto.RecomendacaoRequest;
import com.xpinc.assessor.dto.RecomendacaoResponse;
import com.xpinc.assessor.exception.ResourceNotFoundException;
import com.xpinc.assessor.util.XAIUtil;
import com.xpinc.assessor.service.strategy.StrategyFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RecomendacaoService {
    private final ClienteService clienteService;
    private final StrategyFactory strategyFactory;
    private final XAIUtil xaiUtil;

    public RecomendacaoService(ClienteService clienteService,
                               StrategyFactory strategyFactory,
                               XAIUtil xaiUtil) {
        this.clienteService = clienteService;
        this.strategyFactory = strategyFactory;
        this.xaiUtil = xaiUtil;
    }

    public RecomendacaoResponse gerar(RecomendacaoRequest req) {
        var cliente = clienteService.findById(req.getClienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        var strat = strategyFactory.getStrategy(cliente.getPerfil());
        Carteira carteira = strat.recomendar(cliente);
        String explicacao = xaiUtil.gerarExplicacao(carteira, cliente);
        var aloc = carteira.getAlocacao().entrySet().stream()
            .collect(Collectors.toMap(e -> e.getKey().getNome(), e -> e.getValue()));
        return new RecomendacaoResponse(aloc, explicacao);
    }
}