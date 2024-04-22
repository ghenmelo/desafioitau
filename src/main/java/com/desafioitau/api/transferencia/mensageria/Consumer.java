package com.desafioitau.api.transferencia.mensageria;

import com.desafioitau.api.transferencia.model.Transferencia;
import com.desafioitau.api.transferencia.requests.BacenRequester;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final BacenRequester bacenRequester;

    // ESSE CONSUMER SERIA MELHOR UTILIZADO EM OUTRO SERVICO, POR EXEMPLO NO PROPRIO DO BACEN. FIZ AQUI PARA REPRESENTAR.
    @SqsListener("{sns.queue.url}")
    public void consumeMessages(Transferencia transferencia) {
        Optional.ofNullable(transferencia)
                .ifPresent(bacenRequester::notificarBacen);
    }
}
