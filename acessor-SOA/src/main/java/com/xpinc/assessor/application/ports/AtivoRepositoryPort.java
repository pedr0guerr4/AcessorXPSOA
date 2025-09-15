package com.xpinc.assessor.application.ports;

import com.xpinc.assessor.domain.model.*;
import java.util.*;

public interface AtivoRepositoryPort {
	List<Ativo> findByFiltro(String classe, Integer maxRisco, String minLiquidez);

	List<Ativo> findAll();
}