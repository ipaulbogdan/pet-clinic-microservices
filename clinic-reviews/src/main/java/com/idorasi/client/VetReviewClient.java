package com.idorasi.client;

import com.idorasi.dto.VetReviewApi;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface VetReviewClient {

    @Topic("vet-reviews")
    void send(VetReviewApi vetReviewApi);

}
