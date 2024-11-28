package com.gimhae.sts19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@SpringBootApplication
public class Sts19Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts19Application.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "welcome";
	}
	
}
