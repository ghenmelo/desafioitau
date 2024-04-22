package com.desafioitau.api.transferencia.requests;

import com.desafioitau.api.transferencia.exception.ClienteNaoEncontradoException;
import com.desafioitau.api.transferencia.exception.ErroAoBuscarClienteException;
import com.desafioitau.api.transferencia.model.Cliente;
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
public class CadastroRequester {

    private final RestTemplate restTemplate;

    public Cliente buscaCliente(String idClient) {
        try {
            return Optional.ofNullable(idClient)
                    .filter(StringUtils::isNotBlank)
                    .map(id -> restTemplate.getForObject("/clients/{id}", Cliente.class, id))
                    .orElseThrow(() -> new ClienteNaoEncontradoException(idClient));
        } catch (RestClientException erro) {
            log.error("Erro ao busca cliente. Erro: {}" , erro.getMessage());
            throw new ErroAoBuscarClienteException(erro.getMessage(), idClient);
        }
    }
}
