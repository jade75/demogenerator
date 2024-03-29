package com.example.demo;

import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"ie.dkit","com.example.demo"})
//@ComponentScan("ie.dkit")
@MapperScan("ie.dkit")
//@SpringBootApplication
//@MapperScan("com.example.domo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
