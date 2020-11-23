package hu.webvalto.jatekos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class Receiver {

    private Logger logger = LoggerFactory.getLogger(Receiver.class);
    private static Set<String> probaltSzamok = new HashSet<>();

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "jatek")
    public void jatek(Message message) throws JMSException, InterruptedException {
        String uzenet = ((TextMessage) message).getText();
        if (uzenet.equals("GondoltamEgySzamra")) {
            probaltSzamok.clear();
            logger.info("Indult a jatek");
        } else if (uzenet.equals("IGEN")) {
            logger.info("JUHUUU! Kitalaltam!");
            probaltSzamok.clear();
            return;
        } else if (uzenet.equals("NEM")) {
            logger.info("A fene egye meg...");
        }

        Random random = new Random();
        String szam;
        do {
            szam = "" + (random.nextInt(10) + 1);
        } while (probaltSzamok.contains(szam));
        logger.info("A tippem: " + szam);
        jmsTemplate.convertAndSend(message.getJMSReplyTo(), szam);
        Thread.sleep(3000);
        probaltSzamok.add(szam);
    }
}
