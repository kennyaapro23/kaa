package com.example.kaaenrollmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KaaEnrollmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaaEnrollmentServiceApplication.class, args);
    }

}
