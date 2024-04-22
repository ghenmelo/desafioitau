package com.desafioitau.api.transferencia.pattern.chain.responsability;

import com.desafioitau.api.transferencia.creator.TransferenciaCreator;
import com.desafioitau.api.transferencia.exception.SaldoInsuficienteException;
import com.desafioitau.api.transferencia.model.Transferencia;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.SALDO_INSUFICIENTE_EXCEPTION;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RegraSaldoInsuficienteTest {

    @InjectMocks
    public RegraSaldoSuficiente regraSaldoInsuficiente;

    @Test
    public void testExecutarSucesso() {
        Transferencia transferencia = TransferenciaCreator.criarTransferencia().build();

        RegraSaldoSuficiente spyConta = spy(regraSaldoInsuficiente);

        spyConta.executar(transferencia);

        verify(spyConta).executarProximaRegra(any());
    }

    @Test()
    public void testExecutarException() {
        Transferencia transferencia =
                TransferenciaCreator
                        .criarTransferencia()
                        .comValor(2000)
                        .build();

        assertThrows(SaldoInsuficienteException.class , () -> regraSaldoInsuficiente.executar(transferencia), SALDO_INSUFICIENTE_EXCEPTION.getMessage());
    }
}
