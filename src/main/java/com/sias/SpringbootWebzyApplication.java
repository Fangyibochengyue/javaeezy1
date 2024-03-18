package com.sias;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.sias.dao")
@SpringBootApplication
@ServletComponentScan
public class SpringbootWebzyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebzyApplication.class, args);
    }

}
