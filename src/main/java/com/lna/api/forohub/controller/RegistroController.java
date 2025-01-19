package com.lna.api.forohub.controller;

import com.lna.api.forohub.domain.usuario.DatosRegistroUsuario;
import com.lna.api.forohub.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registro")
public class RegistroController {

    private final UsuarioService usuarioService;

    @Autowired
    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        usuarioService.registrar(datosRegistroUsuario);

        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}
