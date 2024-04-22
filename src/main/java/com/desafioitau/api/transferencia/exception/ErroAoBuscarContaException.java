package com.desafioitau.api.transferencia.exception;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.ERRO_AO_BUSCAR_CONTA;

public class ErroAoBuscarContaException extends RuntimeException {

    public ErroAoBuscarContaException(String mensagem, String id) {
        super(String.format(ERRO_AO_BUSCAR_CONTA.getMessage(), id, mensagem));
    }
}
