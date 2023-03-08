package com.example.BookMyShow_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BookMyShowSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowSystemApplication.class, args);
	}
}
