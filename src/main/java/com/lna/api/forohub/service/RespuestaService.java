package com.lna.api.forohub.service;

import com.lna.api.forohub.domain.respuesta.DatosCreacionRespuesta;
import com.lna.api.forohub.domain.respuesta.DatosRespuestaCreada;
import com.lna.api.forohub.domain.respuesta.DetalleRespuesta;
import com.lna.api.forohub.domain.respuesta.Respuesta;
import com.lna.api.forohub.repository.RespuestaRepository;
import com.lna.api.forohub.repository.TopicoRepository;
import com.lna.api.forohub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class RespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public RespuestaService(RespuestaRepository respuestaRepository, TopicoRepository topicoRepository, UsuarioRepository usuarioRepository) {
        this.respuestaRepository = respuestaRepository;
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public DatosRespuestaCreada crearRespuesta(DatosCreacionRespuesta datosCreacionRespuesta) {
        var autor = usuarioRepository.findById(datosCreacionRespuesta.autor_id())
            .orElseThrow(() -> new EntityNotFoundException("No existe un usuario con el id ingresado"));

        var topico = topicoRepository.findById(datosCreacionRespuesta.topico_id())
            .orElseThrow(() -> new EntityNotFoundException("No existe un topico con el id ingresado"));

        Respuesta respuesta = respuestaRepository.save(new Respuesta(null,
            datosCreacionRespuesta.mensaje(),
            topico,
            LocalDateTime.now(),
            autor,
            false));

        return new DatosRespuestaCreada(respuesta);
    }

    public Page<DetalleRespuesta> verRespuestasDeUnTopico(Pageable paginacion, Long topicoId) {
        return respuestaRepository.findAllByTopicoId(topicoId, paginacion).map(DetalleRespuesta::new);
    }
}
