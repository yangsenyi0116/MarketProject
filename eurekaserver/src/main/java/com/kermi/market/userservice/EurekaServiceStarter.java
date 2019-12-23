package com.kermi.market.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author : Kermi
 * @Date : 2019/12/10 10:05
 * @Version : 1.0
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceStarter {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceStarter.class, args);
    }
}
