package messaging.rabbitmq.producer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import messaging.rabbitmq.dto.Car;

@KafkaClient
public interface KafkaProducer {

    @Topic("${micro.kafka.topic-in}")
    void sendCar(Car car); 

}
