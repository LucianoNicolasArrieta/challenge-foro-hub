package com.lna.api.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCreacionRespuesta(
    @NotBlank
    String mensaje,
    @NotNull
    Long topico_id,
    @NotNull
    Long autor_id
) {
}
