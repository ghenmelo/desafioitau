package com.desafioitau.api.transferencia.pattern.chain.responsability;

import com.desafioitau.api.transferencia.exception.ContaDestinoOuOrigemInativaException;
import com.desafioitau.api.transferencia.exception.LimiteDiarioExcedidioException;
import com.desafioitau.api.transferencia.exception.SaldoInsuficienteException;
import com.desafioitau.api.transferencia.model.Transferencia;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.lang.Double.compare;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class RegraLimiteDiarioNaoExcedido implements RegraTransferenciaValida {

    private RegraTransferenciaValida regraTransferenciaValida;

    @Override
    public void setProximaRegra(RegraTransferenciaValida regra) {
        regraTransferenciaValida.setProximaRegra(regra);
    }

    @Override
    public void executar(Transferencia transferencia) {
        Optional.of(transferencia)
                .map(Transferencia::getValor)
                .filter(valor -> compare(transferencia.getContaOrigem().getLimiteDiario(), valor) > 0)
                .ifPresentOrElse(
                        valor -> this.executarProximaRegra(transferencia),
                        () -> {
                            throw new LimiteDiarioExcedidioException();
                        }
                );
    }

    @Override
    public void executarProximaRegra(Transferencia transferencia) {
        Optional.ofNullable(regraTransferenciaValida)
                .ifPresent(regra -> regra.executar(transferencia));
    }

}
