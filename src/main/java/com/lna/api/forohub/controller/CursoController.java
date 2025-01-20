package com.lna.api.forohub.controller;

import com.lna.api.forohub.domain.curso.DatosRegistroCurso;
import com.lna.api.forohub.domain.curso.DatosRespuestaCurso;
import com.lna.api.forohub.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso) {
        DatosRespuestaCurso cursoCreado = cursoService.registrarNuevoCurso(datosRegistroCurso);

        return ResponseEntity.ok().body(cursoCreado);
    }
}
