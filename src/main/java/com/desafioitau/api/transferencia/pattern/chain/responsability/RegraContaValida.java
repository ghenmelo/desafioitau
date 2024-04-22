package com.desafioitau.api.transferencia.pattern.chain.responsability;

import com.desafioitau.api.transferencia.exception.ContaDestinoOuOrigemInativaException;
import com.desafioitau.api.transferencia.model.Conta;
import com.desafioitau.api.transferencia.model.Transferencia;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RegraContaValida implements RegraTransferenciaValida {

    private RegraTransferenciaValida regraTransferenciaValida;

    @Override
    public void setProximaRegra(RegraTransferenciaValida regra) {
        regraTransferenciaValida.setProximaRegra(regra);
    }

    @Override
    public void executar(Transferencia transferencia) {
        Optional.of(transferencia)
                .filter(t -> this.validaContaAtiva(t.getContaDestino()))
                .filter(t -> this.validaContaAtiva(t.getContaOrigem()))
                .ifPresentOrElse(
                        this::executarProximaRegra,
                        () -> {
                            throw new ContaDestinoOuOrigemInativaException();
                        }
                );
    }

    public boolean validaContaAtiva(Conta conta) {
        return conta.isAtivo();
    }

    @Override
    public void executarProximaRegra(Transferencia transferencia) {
        Optional.ofNullable(regraTransferenciaValida)
                .ifPresent(regra -> regra.executar(transferencia));
    }

}
