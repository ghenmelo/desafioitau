package com.desafioitau.api.transferencia.exception;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.CLIENTE_NAO_ENCONTRADO;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(String id) {
        super(String.format(CLIENTE_NAO_ENCONTRADO.getMessage(), id));
    }
}
