package com.desafioitau.api.transferencia.pattern.chain.responsability;

import com.desafioitau.api.transferencia.model.Transferencia;

public interface RegraTransferenciaValida {

    void setProximaRegra(RegraTransferenciaValida regra);
    void executar(Transferencia transferencia);
    void executarProximaRegra(Transferencia transferencia);
}
