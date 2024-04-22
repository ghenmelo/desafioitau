package com.desafioitau.api.transferencia.model;

import com.desafioitau.api.transferencia.constants.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private String id;

    private String nome;

    private String telefone;

    private String tipoPessoa;
}
