package com.desafioitau.api.transferencia.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessages {

    TIPO_PESSOA_NAO_ENCONTRADO("O tipo de pessoa está inválido!"),
    CLIENTE_NAO_ENCONTRADO("Não foi possível encontrado o cliente %s"),
    CONTA_NAO_ENCONTRADA("Não foi possível encontrar a conta %s"),
    SALDO_INSUFICIENTE_EXCEPTION("Saldo insuficiente!"),
    LIMITE_DIARIO_EXCEDIDO_EXCEPTION("Limite Diário Excedido!"),
    CONTA_DESTINO_OU_ORIGEM_INATIVA("Conta destino ou origem inativa!"),


    ERRO_AO_BUSCAR_CLIENTE("Erro ao buscar o cliente %s, erro: %s"),
    ERRO_AO_BUSCAR_CONTA("Erro ao buscar o conta %s, erro: %s"),
    ;

    private final String message;
}
