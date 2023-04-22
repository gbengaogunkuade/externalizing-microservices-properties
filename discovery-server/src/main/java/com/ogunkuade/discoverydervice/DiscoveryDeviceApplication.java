package com.ogunkuade.discoverydervice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



@SpringBootApplication
@EnableEurekaServer
public class DiscoveryDeviceApplication {


    public static void main(String[] args) {
        SpringApplication.run(DiscoveryDeviceApplication.class, args);
    }



}
