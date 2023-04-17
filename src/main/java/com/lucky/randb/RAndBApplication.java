package com.lucky.randb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
})
public class RAndBApplication {

    public static void main(String[] args) {
        SpringApplication.run(RAndBApplication.class, args);
    }

}
