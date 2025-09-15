package com.xpinc.assessor.service;

import com.xpinc.assessor.application.ports.VariavelMacroPort;
import com.xpinc.assessor.clients.QuotesClient;
import com.xpinc.assessor.domain.model.VariavelMacro;
import org.springframework.stereotype.Service;

@Service
public class MacroSnapshotService {
	private final QuotesClient quotes;
	private final VariavelMacroPort repo;

	public MacroSnapshotService(QuotesClient quotes, VariavelMacroPort repo) {
		this.quotes = quotes;
		this.repo = repo;
	}

	public VariavelMacro snapshotSelic() {
		var selic = quotes.getSelic();
		var v = new VariavelMacro();
		v.setChave("SELIC");
		v.setValor(selic);
		v.setDataRef(java.time.LocalDate.now().toString());
		return repo.save(v);
	}
}