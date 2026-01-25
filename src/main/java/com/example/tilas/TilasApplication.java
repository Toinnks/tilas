package com.example.tilas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//如果写了过滤器就需要添加该注解
@SpringBootApplication
public class TilasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TilasApplication.class, args);
    }

}
