package com.lna.api.forohub.infra.errores;

public class IdEspecificadoNoExiste extends RuntimeException {
    public IdEspecificadoNoExiste(String mensaje) {
        super(mensaje);
    }
}
