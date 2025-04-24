package com.example.kaaconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class KaaConfigServiceApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(KaaConfigServiceApplication.class, args);
    }

}
