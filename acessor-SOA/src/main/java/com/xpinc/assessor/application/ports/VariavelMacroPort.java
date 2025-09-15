package com.xpinc.assessor.application.ports;

import com.xpinc.assessor.domain.model.VariavelMacro;
import java.util.*;

public interface VariavelMacroPort {
	VariavelMacro save(VariavelMacro v);

	List<VariavelMacro> list();
}