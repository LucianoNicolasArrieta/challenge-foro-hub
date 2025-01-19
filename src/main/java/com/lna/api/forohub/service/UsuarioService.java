package com.lna.api.forohub.service;

import com.lna.api.forohub.domain.usuario.DatosRegistroUsuario;
import com.lna.api.forohub.domain.usuario.Usuario;
import com.lna.api.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void registrar(DatosRegistroUsuario datosRegistroUsuario) {
        if (usuarioRepository.existsByUsuario(datosRegistroUsuario.usuario())) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }

        String password = bCryptPasswordEncoder.encode(datosRegistroUsuario.password());
        Usuario usuario = new Usuario(datosRegistroUsuario.usuario(), datosRegistroUsuario.email(), password);

        System.out.println(usuario.getUsuario() + usuario.getPassword() + usuario.getEmail());

        usuarioRepository.save(usuario);
    }
}
