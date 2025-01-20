package com.lna.api.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosTopicoCreado(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fechaDeCreacion,
    Long idAutor,
    Long idCurso
) {
    public DatosTopicoCreado(Topico topico) {
        this(topico.getId(), topico.titulo, topico.getMensaje(), topico.getFechaDeCreacion(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}
