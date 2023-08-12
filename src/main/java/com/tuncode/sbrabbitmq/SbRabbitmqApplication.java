package com.tuncode.sbrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class SbRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbRabbitmqApplication.class, args);
    }

}
