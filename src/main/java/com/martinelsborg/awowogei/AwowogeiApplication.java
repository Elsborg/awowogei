package com.martinelsborg.awowogei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AwowogeiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwowogeiApplication.class, args);
	}

}
