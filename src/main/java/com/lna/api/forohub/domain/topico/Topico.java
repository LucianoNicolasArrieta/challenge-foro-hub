package com.lna.api.forohub.domain.topico;

import com.lna.api.forohub.domain.curso.Curso;
import com.lna.api.forohub.domain.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String titulo;
    String mensaje;
    @Column(name = "fecha_creacion")
    LocalDateTime fechaDeCreacion;
    @Enumerated(EnumType.STRING)
    Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    Usuario autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    Curso curso;


    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null && !datosActualizarTopico.titulo().isBlank()) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null && !datosActualizarTopico.mensaje().isBlank()) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }
    // Respuestas
}
