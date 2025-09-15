package com.xpinc.assessor.dto;

import com.xpinc.assessor.domain.model.enums.*;
import jakarta.validation.constraints.*;

public record RecomendacaoRequest(@NotNull PerfilSuitability perfil, @NotNull ObjetivoPrazo prazo) {
}