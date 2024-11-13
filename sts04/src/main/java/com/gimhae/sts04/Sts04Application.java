package com.gimhae.sts04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.gimhae.sts04.model.DeptVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@SpringBootApplication
public class Sts04Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts04Application.class, args);
	}
	
}
