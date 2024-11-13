package com.gimhae.sts07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@SpringBootApplication
public class Sts07Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts07Application.class, args);
	}

	@GetMapping("/test1")
	public String getMethodName(Model model) {
		model.addAttribute("msg", "hello world");
		return "test1";
	}
	
}
