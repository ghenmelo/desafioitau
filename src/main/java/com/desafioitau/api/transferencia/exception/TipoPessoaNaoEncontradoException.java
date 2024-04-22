package com.desafioitau.api.transferencia.exception;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.TIPO_PESSOA_NAO_ENCONTRADO;

public class TipoPessoaNaoEncontradoException extends RuntimeException {

    public TipoPessoaNaoEncontradoException() {
        super(TIPO_PESSOA_NAO_ENCONTRADO.getMessage());
    }
}
