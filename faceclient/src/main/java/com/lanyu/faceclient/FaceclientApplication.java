package com.lanyu.faceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FaceclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceclientApplication.class, args);
    }

}
