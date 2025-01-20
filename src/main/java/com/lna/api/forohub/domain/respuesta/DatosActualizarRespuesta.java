package com.lna.api.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarRespuesta(
    @NotBlank
    String mensaje
) {
}
