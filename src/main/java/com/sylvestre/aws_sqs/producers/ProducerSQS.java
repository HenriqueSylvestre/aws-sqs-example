package com.sylvestre.aws_sqs.producers;

import com.sylvestre.aws_sqs.dtos.MyMessage;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProducerSQS {

    @Value("${aws.sqs.nome-fila}")
    private String queueName;

    private final SqsTemplate sqsTemplate;

    public void producerMessage(MyMessage message) {

        sqsTemplate.send(sqsSendOptions -> sqsSendOptions
                .queue(queueName)
                .payload(message));
    }
}
