package messaging.rabbitmq.producer;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.scheduling.annotation.Scheduled;
import messaging.rabbitmq.dto.Car;
import messaging.rabbitmq.dto.Motor;

@Singleton
public class Scheduler {
	
	@Inject
	RabbitProducer rabbitProducer;
	
    private static final Logger LOG = LoggerFactory.getLogger(Scheduler.class);
    
    private List<String> marks = Arrays.asList("Acura","Alfa Romeo","Aston Martin","Audi","Bentley","BMW","Bugatti","Buick","Cadillac","Chevrolet");
    private List<String> energies = Arrays.asList("essence","diesel","gaz","electric");
    private List<Integer> power = Arrays.asList(60,70,80,90,100,120,130);
    private Random random = new Random();

    @Scheduled(fixedDelay = "1s") 
    void executeEveryTen() {
        LOG.info("Simple Job every 10 seconds :{}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
        
        Motor motor = new Motor(energies.get(random.nextInt(energies.size()-1)),power.get(random.nextInt(power.size()-1)));
    	Car car = new Car(marks.get(random.nextInt(marks.size()-1)),motor);
    	rabbitProducer.send(car);
    }
}
