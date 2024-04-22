package com.desafioitau.api.transferencia.exception;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.SALDO_INSUFICIENTE_EXCEPTION;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
        super(SALDO_INSUFICIENTE_EXCEPTION.getMessage());
    }
}
