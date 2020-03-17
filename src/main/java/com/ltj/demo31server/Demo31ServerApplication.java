package com.ltj.demo31server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ltj.demo31server.mapper")
@SpringBootApplication
public class Demo31ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo31ServerApplication.class, args);
    }

}
