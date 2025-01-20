package com.lna.api.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record DetalleRespuesta(
    Long id,
    String mensaje,
    Long autor_id,
    LocalDateTime fechaCreacion,
    Boolean solucion
) {
    public DetalleRespuesta(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getAutor().getId(), respuesta.getFechaDeCreacion(), respuesta.getSolucion());
    }
}
