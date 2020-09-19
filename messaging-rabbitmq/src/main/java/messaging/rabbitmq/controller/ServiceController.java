package messaging.rabbitmq.controller;

import javax.inject.Inject;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import messaging.rabbitmq.dto.Car;
import messaging.rabbitmq.dto.Motor;
import messaging.rabbitmq.producer.KafkaProducer;
import messaging.rabbitmq.producer.RabbitProducer;

@Controller("/api")
public class ServiceController {
	
	@Inject
	RabbitProducer rabbitProducer;
	
	@Inject
	KafkaProducer kafkaProducer;
	
	@Inject
	ApplicationContext applicationContext;

	@Post(value="/produce")
	public HttpResponse<String> produce(@Body Car car) {
		try {
			rabbitProducer.send(car);
			return HttpResponse.ok("message have been sent");
		} catch (Exception e) {
			return HttpResponse.badRequest("message have not been sent");
		}
	}

	@Post(value="/produce/kafka")
	public HttpResponse<String> produceEvent(@Body Motor motor) {
		try {
			kafkaProducer.sendCar(motor);
			return HttpResponse.ok("event have been sent");
		} catch (Exception e) {
			return HttpResponse.badRequest("event have not been sent");
		}
	}

}
