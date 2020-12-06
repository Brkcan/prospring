package com.prospring.simpleapp;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.logging.LogManager;


@SpringBootApplication
public class SpringBootSimpleApp {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(SpringBootSimpleApp.class);

		System.err.println("Spring Burada Calisti .../ ");

		application.run(args);
	}
}
