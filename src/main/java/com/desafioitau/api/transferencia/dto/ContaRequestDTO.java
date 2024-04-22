package com.desafioitau.api.transferencia.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ContaRequestDTO {

    private String idOrigem;
    private String idDestino;
}
