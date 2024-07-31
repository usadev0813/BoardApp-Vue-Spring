package com.study.boardappvuespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class BoardAppVueSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardAppVueSpringApplication.class, args);
    }

}
