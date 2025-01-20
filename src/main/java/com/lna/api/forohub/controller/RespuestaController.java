package com.lna.api.forohub.controller;

import com.lna.api.forohub.domain.respuesta.DatosCreacionRespuesta;
import com.lna.api.forohub.domain.respuesta.DatosRespuestaCreada;
import com.lna.api.forohub.domain.respuesta.DetalleRespuesta;
import com.lna.api.forohub.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    private final RespuestaService respuestaService;

    @Autowired
    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaCreada> crearRespuesta(@RequestBody @Valid DatosCreacionRespuesta datosCreacionRespuesta) {
        return ResponseEntity.ok().body(respuestaService.crearRespuesta(datosCreacionRespuesta));
    }

    @GetMapping
    public ResponseEntity<Page<DetalleRespuesta>> verRespuestasDeUnTopico(@PageableDefault(size = 10, sort = {"fechaDeCreacion"}, direction = Sort.Direction.DESC) Pageable paginacion, @RequestParam(required = true) Long topico) {
        return ResponseEntity.ok().body(respuestaService.verRespuestasDeUnTopico(paginacion, topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleRespuesta> editarRespuesta(@PathVariable Long id, @RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok().body(respuestaService.actualizarRespuesta(id, datosActualizarRespuesta, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        respuestaService.eliminarRespuesta(id, userId);
        return ResponseEntity.noContent().build();
    }
}
