package com.sylvestre.aws_sqs.consumers;

import com.sylvestre.aws_sqs.dtos.MyMessage;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ConsumerSQS {

    @Value("${aws.sqs.nome-fila}")
    private String queueName;

    @SqsListener("${aws.sqs.nome-fila}")
    public void listen(MyMessage message) {
        try {
            log.info("Consumindo mensagem da fila SQS - {}. Message: {}", queueName, message );
        } catch (Exception exception) {
            log.error("Erro ao consumir mensagem SQS.", exception);
        }
    }
}
