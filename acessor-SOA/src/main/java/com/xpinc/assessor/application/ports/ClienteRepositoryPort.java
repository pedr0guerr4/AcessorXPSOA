package com.xpinc.assessor.application.ports;

import com.xpinc.assessor.domain.model.*;
import java.util.*;

public interface ClienteRepositoryPort {
	Cliente save(Cliente c);

	Optional<Cliente> findById(Long id);
}