package com.sylvestre.aws_sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class AwsSqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsApplication.class, args);
		log.info("Aplicação iniciada com sucesso!!!");
	}
}
