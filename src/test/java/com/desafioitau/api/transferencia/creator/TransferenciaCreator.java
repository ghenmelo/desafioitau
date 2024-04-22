package com.desafioitau.api.transferencia.creator;

import com.desafioitau.api.transferencia.model.Cliente;
import com.desafioitau.api.transferencia.model.Conta;
import com.desafioitau.api.transferencia.model.Transferencia;
import lombok.Setter;

@Setter
public class TransferenciaCreator {

    private Transferencia transferencia;

    public static TransferenciaCreator criarTransferencia() {
        Transferencia transferencia = new Transferencia();

        transferencia.setContaOrigem(ContaCreator.criarContaOrigem().build());
        transferencia.setContaDestino(ContaCreator.criarContaDestino().build());
        transferencia.setValor(200);
        transferencia.setCliente(ClienteCreator.criarClienteOrigem().build());

        TransferenciaCreator transferenciaCreator = new TransferenciaCreator();
        transferenciaCreator.setTransferencia(transferencia);

        return transferenciaCreator;
    }

    public TransferenciaCreator comContaDestino(Conta conta) {
        this.transferencia.setContaDestino(conta);
        return this;
    }

    public TransferenciaCreator comContaOrigem(Conta conta) {
        this.transferencia.setContaOrigem(conta);
        return this;
    }

    public TransferenciaCreator comValor(double valor) {
        this.transferencia.setValor(valor);
        return this;
    }

    public TransferenciaCreator com(Cliente cliente) {
        this.transferencia.setCliente(cliente);
        return this;
    }

    public Transferencia build() {
        return this.transferencia;
    }
}
