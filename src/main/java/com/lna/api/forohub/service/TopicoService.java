package com.lna.api.forohub.service;

import com.lna.api.forohub.domain.topico.DatosCreacionTopico;
import com.lna.api.forohub.domain.topico.DatosRespuestaTopico;
import com.lna.api.forohub.domain.topico.Status;
import com.lna.api.forohub.domain.topico.Topico;
import com.lna.api.forohub.repository.CursoRepository;
import com.lna.api.forohub.repository.TopicoRepository;
import com.lna.api.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    public TopicoService(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public DatosRespuestaTopico crearNuevoTopico(DatosCreacionTopico datosCreacionTopico) {
        if (topicoRepository.existsByTituloAndMensaje(datosCreacionTopico.titulo(), datosCreacionTopico.mensaje())) {
            throw new RuntimeException("No se permiten topicos duplicados. Ya existe un topico con mismo titulo y mensaje.");
        }

        var autor = usuarioRepository.findById(datosCreacionTopico.idAutor()).orElse(null);
        if (autor == null) {
            throw new RuntimeException("No existe un usuario con el id ingresado");
        }

        var curso = cursoRepository.findById(datosCreacionTopico.idCurso()).orElse(null);
        if (curso == null) {
            throw new RuntimeException("No existe un curso con el id ingresado");
        }

        Topico topico = topicoRepository.save(new Topico(null,
            datosCreacionTopico.titulo(),
            datosCreacionTopico.mensaje(),
            LocalDateTime.now(),
            Status.ABIERTO,
            autor,
            curso));

        DatosRespuestaTopico datos = new DatosRespuestaTopico(topico);
        return datos;
    }
}
