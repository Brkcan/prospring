package com.prospring.custompropertiesprefix;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties(prefix = "myapp")
@Data
public class MyAppProperties {

	private String name;
	private String description;
	private String serverIp;

}
