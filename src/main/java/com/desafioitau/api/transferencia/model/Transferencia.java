package com.desafioitau.api.transferencia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Transferencia {

    private Cliente cliente;

    private double valor;

    private Conta contaOrigem;

    private Conta contaDestino;
}
