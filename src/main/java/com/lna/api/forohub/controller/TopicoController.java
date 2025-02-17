package com.lna.api.forohub.controller;

import com.lna.api.forohub.domain.topico.DatosActualizarTopico;
import com.lna.api.forohub.domain.topico.DatosCreacionTopico;
import com.lna.api.forohub.domain.topico.DatosRespuestaTopico;
import com.lna.api.forohub.domain.topico.DatosTopicoCreado;
import com.lna.api.forohub.service.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    private final TopicoService topicoService;

    @Autowired
    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<DatosTopicoCreado> crearTopico(@RequestBody @Valid DatosCreacionTopico datosCreacionTopico, UriComponentsBuilder uriComponentsBuilder) {
        DatosTopicoCreado datosTopicoCreado = topicoService.crearNuevoTopico(datosCreacionTopico);

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(datosTopicoCreado.id()).toUri();
        return ResponseEntity.created(url).body(datosTopicoCreado);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listarTopicos(@PageableDefault(size = 10, sort = {"fechaDeCreacion"}, direction = Sort.Direction.DESC) Pageable paginacion) {
        return ResponseEntity.ok(topicoService.listarTopicos(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> topicoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.obtenerTopicoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datosActualizarTopico) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(topicoService.actualizarTopico(id, datosActualizarTopico, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        topicoService.eliminarTopico(id, userId);
        return ResponseEntity.noContent().build();
    }
}
