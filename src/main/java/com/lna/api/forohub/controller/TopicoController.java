package com.lna.api.forohub.controller;

import com.lna.api.forohub.domain.topico.DatosCreacionTopico;
import com.lna.api.forohub.domain.topico.DatosRespuestaTopico;
import com.lna.api.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    private TopicoService topicoService;

    @Autowired
    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity crearTopico(@RequestBody @Valid DatosCreacionTopico datosCreacionTopico, UriComponentsBuilder uriComponentsBuilder) {
        DatosRespuestaTopico datosRespuestaTopico = topicoService.crearNuevoTopico(datosCreacionTopico);

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(datosRespuestaTopico.id()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
}
