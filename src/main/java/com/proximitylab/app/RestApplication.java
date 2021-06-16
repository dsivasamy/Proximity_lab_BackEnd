package com.proximitylab.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class RestApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestApplication.class, args);
        log.info("proimity lab challenge application Started");

    }

}
