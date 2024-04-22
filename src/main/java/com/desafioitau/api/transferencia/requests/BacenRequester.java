package com.desafioitau.api.transferencia.requests;

import com.desafioitau.api.transferencia.model.Transferencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Component
@Log4j2
@RequiredArgsConstructor
public class BacenRequester {

    private final RestTemplate restTemplate;

    /**
     * A ideia de retry foi feita direto na request, mas sim, poderíamos colocar essa retentativa diretamente no consumidor no caso de receber
     * uma exception de TooManyRequests. Dessa forma é interessante também pois é possível enviar para uma dll caso necessário.
     *
     */
    @Retryable(value = HttpClientErrorException.TooManyRequests.class, maxAttempts = 10, backoff = @Backoff(delay = 3000))
    public void notificarBacen(Transferencia transferencia) {
        try {
            HttpEntity<Transferencia> request = new HttpEntity<>(transferencia);
            restTemplate.postForLocation("/notificacoes/", request);
        } catch (HttpClientErrorException.TooManyRequests ex) {
            log.error("Erro ao notificar Bacen, tentando novamente ...");

            throw ex;
        }
    }
}
