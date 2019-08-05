package messaging.rabbitmq.producer;

import io.micronaut.configuration.rabbitmq.annotation.Binding;
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;
import messaging.rabbitmq.dto.Car;

@RabbitClient("micronaut-exchange")
public interface RabbitProducer {
	
//    @Binding("micronaut-queue") 
//    void send(byte[] data);
    
    @Binding("${micro.rabbit.queue-in}")
    void send(Car car);	
}
