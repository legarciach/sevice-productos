package com.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.springboot.app.commons.models.entity")
public class ServiceProductosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProductosApplication.class, args);
    }

}
