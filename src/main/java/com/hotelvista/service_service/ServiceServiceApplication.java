package com.hotelvista.service_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceServiceApplication.class, args);
    }
}

