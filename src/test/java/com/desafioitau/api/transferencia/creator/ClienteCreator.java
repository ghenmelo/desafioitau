package com.desafioitau.api.transferencia.creator;

import com.desafioitau.api.transferencia.model.Cliente;
import lombok.Setter;

@Setter
public class ClienteCreator {

    private Cliente cliente;

    public static ClienteCreator criarClienteOrigem() {
        Cliente cliente = new Cliente();

        cliente.setId("idClienteTeste123");
        cliente.setNome("Guilherme Melo");
        cliente.setTipoPessoa("Fisica");
        cliente.setTelefone("35998999220");

        ClienteCreator cc = new ClienteCreator();
        cc.setCliente(cliente);

        return cc;
    }

    public ClienteCreator comTelefone(String tel) {
        this.cliente.setTelefone(tel);
        return this;
    }

    public ClienteCreator comNome(String nome) {
        this.cliente.setNome(nome);
        return this;
    }

    public ClienteCreator comId(String id) {
        this.cliente.setId(id);
        return this;
    }

    public ClienteCreator comTipoPessoa(String tipoPessoa) {
        this.cliente.setTipoPessoa(tipoPessoa);
        return this;
    }

    public Cliente build() {
        return this.cliente;
    }
}
