package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MyConfigApplication {
	
	public static void main(String[] args) {
		
//		new SpringApplicationBuilder(MyConfigApplication.class).properties("spring.config.location=classpath:/myapp.properties").run(args);
		new SpringApplicationBuilder(MyConfigApplication.class).run(args);

	}

}
