 package com.finaltest.amqpconsumer.config;

import com.finaltest.amqpconsumer.service.ConsumerListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

 @Configuration
public class ConsumerConfig implements RabbitListenerConfigurer {

    @Value("${finaltest.rabbitmq.queue}")
    public String queName;

    @Bean
    public MappingJackson2MessageConverter jacksonConverter() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
     public DefaultMessageHandlerMethodFactory handlerMethodFactory() {
        DefaultMessageHandlerMethodFactory myHandle = new DefaultMessageHandlerMethodFactory();
        myHandle.setMessageConverter(jacksonConverter());
        return myHandle;
    }

     @Override
     public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
         registrar.setMessageHandlerMethodFactory(handlerMethodFactory());
     }

     @Autowired
     ConsumerListener consumerListener;

//    @Bean
//    Queue queue() {
//        return new Queue(queName, false);
//    }
//
//
//
//    @Bean
//    MessageListenerContainer listenerContainer(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer simpleListenerContainer = new SimpleMessageListenerContainer();
//        simpleListenerContainer.setConnectionFactory(connectionFactory);
//        simpleListenerContainer.setQueues(queue());
//        simpleListenerContainer.setMessageListener(new ConsumerListener());
//        return simpleListenerContainer;
//    }
}
