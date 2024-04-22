package com.desafioitau.api.transferencia.mappers;

import com.desafioitau.api.transferencia.dto.TransferenciaRequestDTO;
import com.desafioitau.api.transferencia.model.Conta;
import com.desafioitau.api.transferencia.model.Transferencia;

public class TransferenciaMapper {

    public static Transferencia transferenciaRequestDTOtoTransferencia(TransferenciaRequestDTO transferenciaRequestDTO) {
        Conta contaOrigem = new Conta();
        contaOrigem.setId(transferenciaRequestDTO.getConta().getIdOrigem());

        Conta contaDestino = new Conta();
        contaDestino.setId(transferenciaRequestDTO.getConta().getIdDestino());

        return Transferencia.builder()
                .valor(transferenciaRequestDTO.getValor())
                .contaOrigem(contaOrigem)
                .contaDestino(contaDestino)
                .build();
    }
}
