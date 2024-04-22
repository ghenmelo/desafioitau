package com.desafioitau.api.transferencia.constants;

import com.desafioitau.api.transferencia.exception.TipoPessoaNaoEncontradoException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TipoPessoa {

    PESSOA_FISICA("Fisica");

    private final String tipo;

    public TipoPessoa buscarTipoPessoa(String tipo) {
        return Arrays.stream(TipoPessoa.values())
                .filter(t -> getTipo().equals(tipo))
                .findFirst()
                .orElseThrow(TipoPessoaNaoEncontradoException::new);
    }
}
