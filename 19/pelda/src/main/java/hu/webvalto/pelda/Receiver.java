package hu.webvalto.pelda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class Receiver {

    private Logger logger = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "mailbox")
    public void uzenetErkezett(Email uzenet) {
        logger.info("Uzenet erkezett: " + uzenet);
    }

    @JmsListener(destination = "mailbox2")
    public void uzenetErkezettEsValasz(Message uzenet) throws JMSException {
        logger.info("Uzenet erkezett: " + uzenet);
        logger.info("Valasz kuldese");
        jmsTemplate.send(uzenet.getJMSReplyTo(), new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("Valasz a masodik uzenetre");
            }
        });
    }
}
