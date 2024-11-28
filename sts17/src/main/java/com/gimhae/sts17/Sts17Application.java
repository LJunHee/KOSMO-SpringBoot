package com.gimhae.sts17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@SpringBootApplication
public class Sts17Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts17Application.class, args);
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
