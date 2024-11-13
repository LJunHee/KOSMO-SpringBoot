package com.gimhae.sts02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@SpringBootApplication
public class Sts02Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts02Application.class, args);
	}
	
	@GetMapping("/")
	public String getMethodName() {
		return "hello world";
	}
	

}
