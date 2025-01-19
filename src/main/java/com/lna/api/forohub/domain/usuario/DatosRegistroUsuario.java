package com.lna.api.forohub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
    @NotBlank
    String usuario,
    @NotBlank
    @Email
    String email,
    @NotBlank
    String password
) {
}
