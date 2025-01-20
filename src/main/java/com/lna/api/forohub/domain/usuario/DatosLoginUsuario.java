package com.lna.api.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosLoginUsuario(
    @NotBlank
    String usuario,
    @NotBlank
    String password
) {
}
