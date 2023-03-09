package com.bug.spring.kafka.staletokenbug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventConsumer {

  private static final Logger logger = LoggerFactory.getLogger(KafkaEventConsumer.class);

  @KafkaListener(
      topics = "mock-secure-topic")
  public void consume(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
    logger.info("Event received: {}", message);
  }

}
