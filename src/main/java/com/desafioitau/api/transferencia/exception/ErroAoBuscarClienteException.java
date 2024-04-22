package com.desafioitau.api.transferencia.exception;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.ERRO_AO_BUSCAR_CLIENTE;

public class ErroAoBuscarClienteException extends RuntimeException {

    public ErroAoBuscarClienteException(String mensagem, String id) {
        super(String.format(ERRO_AO_BUSCAR_CLIENTE.getMessage(), id, mensagem));
    }
}
