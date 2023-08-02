package amqp.producer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMqProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);
    private final RabbitTemplate rabbitTemplate;

    /*
      retrieve particular message from producer and will be sent to the queue via exchange
     */
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    /*
     for sending particular message to the queue by exchange
     */
    @Value("${rabbitmq.routing.key.name}")
    private String routingKey;

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent by producer --> %s", message));
        rabbitTemplate.convertAndSend(
                exchange,
                routingKey,
                message
        );
    }
}
