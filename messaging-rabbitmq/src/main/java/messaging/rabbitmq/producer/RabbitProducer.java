package messaging.rabbitmq.producer;

import io.micronaut.configuration.rabbitmq.annotation.Binding;
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;
import messaging.rabbitmq.dto.Car;

@RabbitClient("micronaut-exchange")
public interface RabbitProducer {
    
    @Binding("${micro.rabbit.queue-in}")
    void send(Car car);	
}
