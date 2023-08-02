package controller;

import amqp.producer.RabbitMqJsonProducer;
import dto.MyJsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rabbitmq/jsonmessage")
@RequiredArgsConstructor
public class MessageJsonController {

    private final RabbitMqJsonProducer jsonProducer;

    @PostMapping("/produce")
    public ResponseEntity<String> sendMessage(@RequestBody MyJsonObject jsonMessage) {
        jsonProducer.sendJSONMessage(jsonMessage);
        return ResponseEntity.ok("JSON Message sent to the RabbitMQ");
    }

}
