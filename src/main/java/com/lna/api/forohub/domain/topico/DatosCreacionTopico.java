package com.lna.api.forohub.domain.topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCreacionTopico(
    @NotBlank
    String titulo,
    @NotBlank
    String mensaje,
    @NotNull
    @JsonAlias("autor_id")
    Long idAutor,
    @NotNull
    @JsonAlias("curso_id")
    Long idCurso
) {
}
