package com.desafioitau.api.transferencia.requests;

import com.desafioitau.api.transferencia.exception.ContaNaoEncontradaException;
import com.desafioitau.api.transferencia.exception.ErroAoBuscarContaException;
import com.desafioitau.api.transferencia.model.Conta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Log4j2
public class ContasRequester {

    private final RestTemplate restTemplate;

    public Conta buscaConta(String idConta) {
        try {
            return Optional.ofNullable(idConta)
                    .filter(StringUtils::isNotBlank)
                    .map(id -> restTemplate.getForObject("/contas/{id}", Conta.class, id))
                    .orElseThrow(() -> new ContaNaoEncontradaException(idConta));
        } catch (RestClientException erro) {
            log.error("Erro ao busca conta. Erro: {}" , erro.getMessage());
            throw new ErroAoBuscarContaException(erro.getMessage(), idConta);
        }
    }
}
