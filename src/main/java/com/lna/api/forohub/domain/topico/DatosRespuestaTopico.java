package com.lna.api.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
    String titulo,
    String mensaje,
    LocalDateTime fechaDeCreacion,
    String status,
    Long idAutor,
    Long idCurso
) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.titulo, topico.getMensaje(), topico.getFechaDeCreacion(), topico.getStatus().toString(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}