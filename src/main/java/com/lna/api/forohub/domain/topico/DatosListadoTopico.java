package com.lna.api.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fechaDeCreacion,
    String status,
    Long idAutor,
    Long idCurso
) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.titulo, topico.getMensaje(), topico.getFechaDeCreacion(), topico.getStatus().toString(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}