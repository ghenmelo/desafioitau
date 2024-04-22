package com.desafioitau.api.transferencia.mensageria;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.desafioitau.api.transferencia.model.Transferencia;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("{sns.queue.url}")
    private String queue;

    public void sendMessage(Transferencia transferencia) {
        queueMessagingTemplate.convertAndSend(queue, transferencia);
    }
}
