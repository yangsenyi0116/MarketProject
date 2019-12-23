package com.kermi.market.goodsservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.kermi.market.goodsservice.mapper")
@EnableEurekaClient
public class GoodsserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsserviceApplication.class, args);
    }

}
