package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootExceptionHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExceptionHandlerApplication.class, args);
	}

}
