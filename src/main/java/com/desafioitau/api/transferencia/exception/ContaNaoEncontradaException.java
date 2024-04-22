package com.desafioitau.api.transferencia.exception;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.CONTA_NAO_ENCONTRADA;

public class ContaNaoEncontradaException extends RuntimeException {

    public ContaNaoEncontradaException(String conta) {
        super(String.format(CONTA_NAO_ENCONTRADA.getMessage(), conta));
    }
}
