package messaging.rabbitmq.receiver;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.configuration.rabbitmq.annotation.Queue;
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;
import messaging.rabbitmq.dto.Car;
import messaging.rabbitmq.producer.KafkaProducer;

@RabbitListener
public class RabbitReceiver {
	private static final Logger LOG = LoggerFactory.getLogger(RabbitReceiver.class);
	
	@Inject
	KafkaProducer kafkaProducer;
	
    @Queue("${micro.rabbit.queue-in}")
    public void receive(Car car) {
    	LOG.info("--> New event consumed");
    	// kafkaProducer.sendCar(car.getMotor());
    	LOG.info("Car <{}> have a motor with <{}> watts",car.getMark(),car.getMotor().getPowor());
    }

}
