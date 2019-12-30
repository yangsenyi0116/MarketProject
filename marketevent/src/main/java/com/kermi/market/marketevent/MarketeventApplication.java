package com.kermi.market.marketevent;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@MapperScan("com.example.mapper")
@SpringBootApplication
@EnableEurekaClient
public class MarketeventApplication {
	public static void main(String[] args) {
		SpringApplication.run(MarketeventApplication.class, args);
	}

}
