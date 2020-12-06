package com.prospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProspringApplication.class, args);
	}

	@RequestMapping("/greetinExample")
	public String greeting ()
	{
		return "<h1> Spring Hello.../ </h1>";
	}
}
