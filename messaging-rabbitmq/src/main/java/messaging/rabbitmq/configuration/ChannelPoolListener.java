package messaging.rabbitmq.configuration;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.configuration.rabbitmq.connect.ChannelInitializer;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class ChannelPoolListener { // extends ChannelInitializer {

//    @Override
//    public void initialize(Channel channel) throws IOException {
//        channel.exchangeDeclare("micronaut-exchange", BuiltinExchangeType.DIRECT, true); 
//        channel.queueDeclare("micronaut-queue", true, false, false, null); 
//        channel.queueBind("micronaut-queue", "micronaut-exchange", "micronaut-queue"); 
//    }
}