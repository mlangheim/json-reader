package com.example.jsonreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JsonReaderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JsonReaderApplication.class, args);
	}
}

