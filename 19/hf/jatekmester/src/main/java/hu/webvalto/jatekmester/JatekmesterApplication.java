package hu.webvalto.jatekmester;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Random;

@SpringBootApplication
public class JatekmesterApplication {

    private static final Logger logger = LoggerFactory.getLogger(JatekmesterApplication.class);

    public static void main(String[] args) throws JMSException {

        ConfigurableApplicationContext context = SpringApplication.run(JatekmesterApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        Random random = new Random();
        String randomszam = "" + (random.nextInt(10) + 1);
        logger.info("Gondoltam egy szamra: " + randomszam);
        Message receivedMessage = jmsTemplate.sendAndReceive("jatek", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("GondoltamEgySzamra");
            }
        });
        boolean kitalalta = false;
        MessageConverter converter = new SimpleMessageConverter();
        do {
            String valasz = (String) converter.fromMessage(receivedMessage);
            logger.info("A kapott tipp: " + valasz);
            if (valasz.equals(randomszam)) {
                kitalalta = true;
                jmsTemplate.convertAndSend("jatek", "IGEN");
                logger.info("GRATULALOK, kitalta a szamot!");
            } else {
                logger.info("SAJNOS nem erre gondoltam!");
                receivedMessage = jmsTemplate.sendAndReceive("jatek", new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage("NEM");
                    }
                });
            }
        } while (!kitalalta);
    }

}
