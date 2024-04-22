package com.desafioitau.api.transferencia.pattern.chain.responsability;

import com.desafioitau.api.transferencia.model.Transferencia;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TranferenciaValidaHandler {

    private final ApplicationContext applicationContext;

    public void executaRegraValidarTransferencia (Transferencia transferencia) {
        this.criarRegras().executar(transferencia);
    }

    private RegraTransferenciaValida criarRegras() {
        RegraContaValida regraContaValida = applicationContext.getBean(RegraContaValida.class);
        RegraSaldoSuficiente regraSaldoSuficiente = applicationContext.getBean(RegraSaldoSuficiente.class);
        RegraLimiteDiarioNaoExcedido regraLimiteDiarioNaoExcedido = applicationContext.getBean(RegraLimiteDiarioNaoExcedido.class);

        regraContaValida.setProximaRegra(regraSaldoSuficiente);
        regraSaldoSuficiente.setProximaRegra(regraLimiteDiarioNaoExcedido);

        return regraContaValida;
    }
}
