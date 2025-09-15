package com.xpinc.assessor.application.ports;

import com.xpinc.assessor.domain.model.*;
import java.util.*;

public interface CarteiraRepositoryPort {
	Carteira save(Carteira c);

	void saveAlocacoes(Long carteiraId, List<Alocacao> alocacoes);
}