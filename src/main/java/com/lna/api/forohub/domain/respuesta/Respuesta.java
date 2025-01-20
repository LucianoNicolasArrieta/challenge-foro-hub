package com.lna.api.forohub.domain.respuesta;

import com.lna.api.forohub.domain.topico.Topico;
import com.lna.api.forohub.domain.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Entity(name = "Respuesta")
@Table(name = "respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String mensaje;
    @ManyToOne
    @JoinColumn(name = "topico_id")
    Topico topico;
    @Column(name = "fecha_creacion")
    LocalDateTime fechaDeCreacion;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    Usuario autor;
    Boolean solucion;

    public void actualizar(DatosActualizarRespuesta datosActualizarRespuesta) {
        if (datosActualizarRespuesta.mensaje() != null && !datosActualizarRespuesta.mensaje().isEmpty()) {
            this.mensaje = datosActualizarRespuesta.mensaje();
        }
    }

    public void marcarComoSolucion() {
        this.solucion = true;
        topico.cerrarTopico();
    }
}
