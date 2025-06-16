package com.xpinc.assessor.service.strategy;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StrategyFactory {
    private final List<RecomendacaoStrategy> strategies;
    public StrategyFactory(List<RecomendacaoStrategy> strategies) {
        this.strategies = strategies;
    }
    public RecomendacaoStrategy getStrategy(com.xpinc.assessor.domain.PerfilInvestidor perfil) {
        return strategies.stream().filter(s -> {
            // simplistic match by class name or implement getPerfil if desired
            return true;
        }).findFirst().orElse(strategies.get(0));
    }
}