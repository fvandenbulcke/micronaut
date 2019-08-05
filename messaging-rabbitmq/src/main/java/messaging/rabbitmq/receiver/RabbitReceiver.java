package messaging.rabbitmq.receiver;

import io.micronaut.configuration.rabbitmq.annotation.Queue;
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;
import messaging.rabbitmq.dto.Car;

@RabbitListener
public class RabbitReceiver {
	
    @Queue("${micro.rabbit.queue-in}")
    public void receive(Car car) {
    	System.out.println("<"+car.getLabel()+"> have been received from rabbit");
    }

}
