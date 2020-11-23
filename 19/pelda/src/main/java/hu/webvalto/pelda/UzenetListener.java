package hu.webvalto.pelda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class UzenetListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(UzenetListener.class);

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String msg = ((TextMessage) message).getText();
                logger.info("Beerkezett uzenet: " + msg);
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
