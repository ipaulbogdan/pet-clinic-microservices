package com.idorasi.listener;

import com.idorasi.dto.VetReviewApi;
import com.idorasi.service.VetService;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageBody;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@KafkaListener(groupId = "pet-clinic", offsetReset = OffsetReset.EARLIEST)
@AllArgsConstructor
@Slf4j
public class VetReviewListener {

    private VetService vetService;

    @Topic(value = "vet-reviews")
    public void receive(@MessageBody VetReviewApi vetReviewApi) {
        log.info("Received vet review: {}", vetReviewApi);

        vetService.processVetReview(vetReviewApi);
    }

}
