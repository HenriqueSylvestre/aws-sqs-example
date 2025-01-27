package com.sylvestre.aws_sqs.dtos;

import lombok.Builder;

@Builder
public record MyMessage(String id,
                        String name) {
}
