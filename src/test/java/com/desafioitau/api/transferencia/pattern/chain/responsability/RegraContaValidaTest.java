package com.desafioitau.api.transferencia.pattern.chain.responsability;

import com.desafioitau.api.transferencia.creator.ContaCreator;
import com.desafioitau.api.transferencia.creator.TransferenciaCreator;
import com.desafioitau.api.transferencia.exception.ContaDestinoOuOrigemInativaException;
import com.desafioitau.api.transferencia.model.Transferencia;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import static com.desafioitau.api.transferencia.constants.ErrorMessages.CONTA_DESTINO_OU_ORIGEM_INATIVA;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class RegraContaValidaTest {

    @InjectMocks
    public RegraContaValida regraContaValida;

    @Test
    public void testExecutarSucesso() {
        Transferencia transferencia = TransferenciaCreator.criarTransferencia().build();

        RegraContaValida spyConta = spy(regraContaValida);

        spyConta.executar(transferencia);

        verify(spyConta).executarProximaRegra(any());
    }

    @Test()
    public void testExecutarException() {
        Transferencia transferencia =
                TransferenciaCreator
                        .criarTransferencia()
                        .comContaOrigem(
                                ContaCreator.criarContaOrigem().isAtivo(false).build()
                        )
                        .build();

        assertThrows(ContaDestinoOuOrigemInativaException.class , () -> regraContaValida.executar(transferencia), CONTA_DESTINO_OU_ORIGEM_INATIVA.getMessage());
    }
}
