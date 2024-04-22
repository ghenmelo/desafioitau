package com.desafioitau.api.transferencia.exception;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.CONTA_DESTINO_OU_ORIGEM_INATIVA;

public class ContaDestinoOuOrigemInativaException extends RuntimeException {

    public ContaDestinoOuOrigemInativaException() {
        super(CONTA_DESTINO_OU_ORIGEM_INATIVA.getMessage());
    }
}
