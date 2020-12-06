package com.prospring.simpleapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MyComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyComponent.class);

	@Autowired
	MyComponent (ApplicationArguments args)
	{
		boolean enable = args.containsOption("enable");
		if(enable)
			LOGGER.info("## > You are enabled!");
		List<String> _args = args.getNonOptionArgs();
		LOGGER.info("## > extra args ...");
		if(!_args.isEmpty())
			_args.forEach(file -> LOGGER.info(file));
	}
}
