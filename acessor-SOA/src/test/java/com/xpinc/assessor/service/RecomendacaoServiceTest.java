package com.xpinc.assessor.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.xpinc.assessor.domain.Carteira;
import com.xpinc.assessor.domain.Cliente;
import com.xpinc.assessor.domain.PerfilInvestidor;
import com.xpinc.assessor.dto.RecomendacaoRequest;
import com.xpinc.assessor.service.strategy.Strategy;
import com.xpinc.assessor.service.strategy.StrategyFactory;
import com.xpinc.assessor.util.XAIUtil;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RecomendacaoServiceTest {

	@Mock
	ClienteService clienteService;
	@Mock
	StrategyFactory strategyFactory;
	@Mock
	XAIUtil xaiUtil;

	@InjectMocks
	RecomendacaoService service;

	@Test
	void deveGerarCarteiraDeAcordoComPerfil() {
		var cliente = new Cliente();
		cliente.setPerfilInvestidor(PerfilInvestidor.CONSERVADOR);

		when(clienteService.findEntityOrThrow(1L)).thenReturn(cliente);

		Strategy strat = mock(Strategy.class);
		when(strategyFactory.getStrategy(PerfilInvestidor.CONSERVADOR)).thenReturn(strat);
		when(strat.recomendar(cliente)).thenReturn(Carteira.conservadoraPadrao());

		when(xaiUtil.gerarExplicacao(any(Carteira.class), any())).thenReturn("explicacao-ok");

		var req = new RecomendacaoRequest();
		req.setClienteId(1L);

		var resp = service.gerar(req);

		assertNotNull(resp);
		verify(strategyFactory).getStrategy(PerfilInvestidor.CONSERVADOR);
		verify(strat).recomendar(cliente);
		verify(xaiUtil).gerarExplicacao(any(Carteira.class), any());
	}
}
