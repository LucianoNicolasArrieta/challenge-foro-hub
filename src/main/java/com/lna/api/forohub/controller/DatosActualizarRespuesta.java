package com.lna.api.forohub.controller;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarRespuesta(
    @NotBlank
    String mensaje
) {
}
