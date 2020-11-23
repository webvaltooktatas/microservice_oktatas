package hu.webvalto.pelda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;

@SpringBootApplication
@EnableJms
public class PeldaApplication {

    private static final Logger logger = LoggerFactory.getLogger(PeldaApplication.class);

    @Bean
    public MessageListener uzenetListener() {
        return new UzenetListener();
    }

//    @Bean
//    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
//        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setDestinationName("mailbox");
//        container.setMessageListener(uzenetListener());
//        return container;
//    }

//    @Bean
//    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setErrorHandler();
//    }

    @Bean
    public MessageConverter jackJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }


    public static void main(String[] args) throws JMSException {

        ConfigurableApplicationContext context = SpringApplication.run(PeldaApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        logger.info("Kuldeni fogunk egy uzenetet");
        jmsTemplate.convertAndSend("mailbox", new Email("info@webvalto.hu", "hello"));
        logger.info("Elkuldve az uzenet");

        Message received = jmsTemplate.sendAndReceive("mailbox2", new MessageCreator() {
            @Override
            public javax.jms.Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("Masodik uzenet");
            }
        });
        logger.info("Valasz uzenet erkezett: " + new SimpleMessageConverter().fromMessage(received));
    }

}
