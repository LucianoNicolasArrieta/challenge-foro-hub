package com.lna.api.forohub.controller;

import com.lna.api.forohub.domain.curso.DatosRegistroCurso;
import com.lna.api.forohub.domain.curso.DatosRespuestaCurso;
import com.lna.api.forohub.service.CursoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cursos")
@SecurityRequirement(name = "bearer-key")
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

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaCurso>> listarCursos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacion) {
        return ResponseEntity.ok(cursoService.listarCursos(paginacion));
    }
}
