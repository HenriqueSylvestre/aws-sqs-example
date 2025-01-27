package com.sylvestre.aws_sqs.producers;

import com.sylvestre.aws_sqs.dtos.MyMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerScheduledSQS {

    @Value("${aws.sqs.nome-fila}")
    private String queueName;

    private final ProducerSQS producerSQS;

    @Scheduled(fixedDelay = 30000)
    public void producerScheduledSQS() {
        try {
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva", "Frank, Sylvestre");
            Random random = new Random();
            String randomName = names.get(random.nextInt(names.size()));

            final var myMessage = MyMessage.builder()
                    .id(UUID.randomUUID().toString())
                    .name(randomName)
                    .build();
            producerSQS.producerMessage(myMessage);

        } catch (Exception exception) {
            log.error("Erro ao enviar mensagem para fila SQS.", exception);
        }
    }
}
