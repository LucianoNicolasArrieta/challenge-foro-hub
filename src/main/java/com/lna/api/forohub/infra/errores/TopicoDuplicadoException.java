package com.lna.api.forohub.infra.errores;

public class TopicoDuplicadoException extends RuntimeException {
    public TopicoDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
