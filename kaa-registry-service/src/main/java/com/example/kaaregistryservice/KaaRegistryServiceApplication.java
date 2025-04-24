package com.example.kaaregistryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KaaRegistryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaaRegistryServiceApplication.class, args);
    }

}
