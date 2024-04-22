package com.desafioitau.api.transferencia.creator;

import com.desafioitau.api.transferencia.model.Conta;
import lombok.Setter;

@Setter
public class ContaCreator {

    private Conta conta;

    public static ContaCreator criarContaOrigem() {
        Conta conta = new Conta();

        conta.setId("idTesteContaOrigem123");
        conta.setAtivo(true);
        conta.setSaldo(1000);
        conta.setLimiteDiario(500);

        ContaCreator cc = new ContaCreator();
        cc.setConta(conta);

        return cc;
    }

    public static ContaCreator criarContaDestino() {
        Conta conta = new Conta();

        conta.setId("idTesteContaDestino123");
        conta.setAtivo(true);
        conta.setSaldo(1000);
        conta.setLimiteDiario(500);

        ContaCreator cc = new ContaCreator();
        cc.setConta(conta);

        return cc;
    }

    public ContaCreator comSaldo(double saldo) {
        this.conta.setSaldo(saldo);
        return this;
    }

    public ContaCreator isAtivo(boolean ativo) {
        this.conta.setAtivo(ativo);
        return this;
    }

    public ContaCreator comId(String id) {
        this.conta.setId(id);
        return this;
    }

    public ContaCreator comLimiteDiario(double limiteDiario) {
        this.conta.setLimiteDiario(limiteDiario);
        return this;
    }

    public Conta build() {
        return this.conta;
    }
}
