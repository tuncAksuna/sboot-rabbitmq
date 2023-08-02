package amqp.producer;

import dto.MyJsonObject;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMqJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonProducer.class);
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.name.json}")
    private String routingJsonKey;

    public void sendJSONMessage(MyJsonObject jsonMessage) {
        LOGGER.info(String.format("JSON Message sent by producer --> %s", jsonMessage.toString()));
        rabbitTemplate.convertAndSend(
                exchange,
                routingJsonKey,
                jsonMessage
        );
    }
}
