package com.desafioitau.api.transferencia.pattern.chain.responsability;

import com.desafioitau.api.transferencia.creator.TransferenciaCreator;
import com.desafioitau.api.transferencia.exception.LimiteDiarioExcedidioException;
import com.desafioitau.api.transferencia.model.Transferencia;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.LIMITE_DIARIO_EXCEDIDO_EXCEPTION;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RegraLimiteDiarioNaoExcedidoTest {

    @InjectMocks
    public RegraLimiteDiarioNaoExcedido regraLimiteDiarioNaoExcedido;

    @Test
    public void testExecutarSucesso() {
        Transferencia transferencia = TransferenciaCreator.criarTransferencia().build();

        RegraLimiteDiarioNaoExcedido spyConta = spy(regraLimiteDiarioNaoExcedido);

        spyConta.executar(transferencia);

        verify(spyConta).executarProximaRegra(any());
    }

    @Test()
    public void testExecutarException() {
        Transferencia transferencia =
                TransferenciaCreator
                        .criarTransferencia()
                        .comValor(1000)
                        .build();

        assertThrows(LimiteDiarioExcedidioException.class , () -> regraLimiteDiarioNaoExcedido.executar(transferencia), LIMITE_DIARIO_EXCEDIDO_EXCEPTION.getMessage());
    }
}
