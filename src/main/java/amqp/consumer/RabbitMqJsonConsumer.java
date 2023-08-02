package amqp.consumer;

import dto.MyJsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonConsumer.class);

    /**
     * Method subscribed the particular queue to receive the JSON MESSAGE from the queue
     */
    @RabbitListener(queues = "${rabbitmq.queue.name.json}")
    public void consume(MyJsonObject jsonMessage) {
        LOGGER.info(String.format("Received the JSON message from Queue --> %s", jsonMessage.toString()));
    }

}
