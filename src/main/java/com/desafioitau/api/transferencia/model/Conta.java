package com.desafioitau.api.transferencia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    private String id;

    private double saldo;

    private boolean ativo;

    private double limiteDiario;
}
