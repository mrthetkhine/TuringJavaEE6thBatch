package com.javaee6.webmvc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringWebMvcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebMvcDemoApplication.class, args);
	}

}
