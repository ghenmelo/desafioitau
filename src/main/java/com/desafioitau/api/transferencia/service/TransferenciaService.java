package com.desafioitau.api.transferencia.service;

import com.desafioitau.api.transferencia.mensageria.Producer;
import com.desafioitau.api.transferencia.model.Conta;
import com.desafioitau.api.transferencia.model.Transferencia;
import com.desafioitau.api.transferencia.pattern.chain.responsability.TranferenciaValidaHandler;
import com.desafioitau.api.transferencia.requests.CadastroRequester;
import com.desafioitau.api.transferencia.requests.ContasRequester;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final CadastroRequester cadastroRequester;
    private final ContasRequester contasRequester;
    private final TranferenciaValidaHandler tranferenciaValidaHandler;
    private final Producer producer;

    public void executarTransferencia(Transferencia transferencia) {
        cadastroRequester.buscaCliente(transferencia.getCliente().getId());
        Conta contaOrigem = contasRequester.buscaConta(transferencia.getContaOrigem().getId());
        Conta contaDestino = contasRequester.buscaConta(transferencia.getContaDestino().getId());

        transferencia.setContaOrigem(contaOrigem);
        transferencia.setContaDestino(contaDestino);

        tranferenciaValidaHandler.executaRegraValidarTransferencia(transferencia);

        producer.sendMessage(transferencia);
    }

}
