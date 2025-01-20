package com.lna.api.forohub.controller;

import com.lna.api.forohub.domain.respuesta.DatosCreacionRespuesta;
import com.lna.api.forohub.domain.respuesta.DatosRespuestaCreada;
import com.lna.api.forohub.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
