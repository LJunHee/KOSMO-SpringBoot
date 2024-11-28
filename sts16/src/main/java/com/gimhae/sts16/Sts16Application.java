package com.gimhae.sts16;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@SpringBootApplication
public class Sts16Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts16Application.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "index controller print....";
	}
//	@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
	@GetMapping("/dept/")
	public List<DeptVo> dept() {
		System.out.println("list");
		List<DeptVo> list = List.of(
				DeptVo.builder().deptno(1111).dname("test1").loc("test").build(),
				DeptVo.builder().deptno(2222).dname("test2").loc("test").build(),
				DeptVo.builder().deptno(3333).dname("test3").loc("test").build(),
				DeptVo.builder().deptno(4444).dname("test4").loc("test").build()
				);
		
		return list;
	}
	
}
