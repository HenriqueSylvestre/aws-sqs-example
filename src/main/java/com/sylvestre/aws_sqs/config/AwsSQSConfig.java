package com.sylvestre.aws_sqs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Configuration
public class AwsSQSConfig {

    @Value("${spring.cloud.aws.region.static}")
    private String region;
    @Value("${spring.cloud.aws.sqs.endpoint}")
    private String endpointOverride;

    @Bean
    public SqsAsyncClient sqsAsyncClient(){
        return SqsAsyncClient
                .builder()
                .region(Region.of(region))
                .endpointOverride(URI.create(endpointOverride))
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();
    }
}
