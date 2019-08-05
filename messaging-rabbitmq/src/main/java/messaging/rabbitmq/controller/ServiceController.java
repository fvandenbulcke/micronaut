package messaging.rabbitmq.controller;

import javax.inject.Inject;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import messaging.rabbitmq.dto.Car;
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

	@Post(value="/produce/{label}")
	public HttpResponse<String> produce(@PathVariable String label) {
		try {
			rabbitProducer.send(new Car(label));
			return HttpResponse.ok("message have been sent");
		} catch (Exception e) {
			return HttpResponse.badRequest("message have not been sent");
		}
	}

	@Post(value="/produce/kafka/{label}")
	public HttpResponse<String> produceEvent(@PathVariable String label) {
		try {
			kafkaProducer.sendCar(new Car(label));
			return HttpResponse.ok("event have been sent");
		} catch (Exception e) {
			return HttpResponse.badRequest("event have not been sent");
		}
	}

}
