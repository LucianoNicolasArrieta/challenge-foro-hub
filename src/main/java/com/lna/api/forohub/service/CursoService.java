package com.lna.api.forohub.service;

import com.lna.api.forohub.domain.curso.Curso;
import com.lna.api.forohub.domain.curso.DatosRegistroCurso;
import com.lna.api.forohub.domain.curso.DatosRespuestaCurso;
import com.lna.api.forohub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public DatosRespuestaCurso registrarNuevoCurso(DatosRegistroCurso datosRegistroCurso) {
        Curso curso = cursoRepository.save(new Curso(datosRegistroCurso));
        DatosRespuestaCurso cursoRespuesta = new DatosRespuestaCurso(curso.getId(), curso.getNombre(), curso.getCategoria().toString());
        return cursoRespuesta;
    }

    public Page<DatosRespuestaCurso> listarCursos(Pageable paginacion) {
        return cursoRepository.findAll(paginacion).map(DatosRespuestaCurso::new);
    }
}
