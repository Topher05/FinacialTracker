package com.financialTracker.FT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//This is a basic Financial Tracker web app.

//Dependencies used are: Spring Web, Spring Data JPA, MySQL Driver, Lombok, Spring Boot Actuator, MapStruct

@SpringBootApplication
public class FtApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtApplication.class, args);
	}

}
