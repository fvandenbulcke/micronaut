package messaging.rabbitmq.receiver;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import messaging.rabbitmq.dto.Car;

@KafkaListener
public class KafkaReceiver {
	
    @Topic("${micro.kafka.topic-in}")
    public void receive(Car car) {
    	System.out.println("<"+car.getLabel()+"> have been received from kafka");
    }

}
