package com.lna.api.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosRespuestaCreada(
    String mensaje,
    Long topico_id,
    LocalDateTime fecha_creacion,
    Long autor_id,
    Boolean solucion
) {
    public DatosRespuestaCreada(Respuesta respuesta){
        this(respuesta.getMensaje(), respuesta.getTopico().getId(), respuesta.getFechaDeCreacion(), respuesta.getAutor().getId(), respuesta.getSolucion());
    }
}
