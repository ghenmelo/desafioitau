package com.desafioitau.api.transferencia.exception;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.LIMITE_DIARIO_EXCEDIDO_EXCEPTION;

public class LimiteDiarioExcedidioException extends RuntimeException {

    public LimiteDiarioExcedidioException() {
        super(LIMITE_DIARIO_EXCEDIDO_EXCEPTION.getMessage());
    }
}
