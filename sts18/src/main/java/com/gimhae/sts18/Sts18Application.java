package com.gimhae.sts18;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gimhae.sts18.model.EmpRepo;
import com.gimhae.sts18.model.entity.Emp;
import com.gimhae.sts18.model.entity.Roles;

@SpringBootApplication
public class Sts18Application implements CommandLineRunner{
	@Autowired
	EmpRepo empRepo;
	@Autowired
	BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(Sts18Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Emp> list = List.of(
				Emp.builder().num(1).role(new Roles[]{Roles.ADMIN}).email("user1").name("tester1").pw(encoder.encode("1234")).build(),
				Emp.builder().num(2).role(new Roles[]{Roles.USER}).email("user2").name("tester2").pw(encoder.encode("1234")).build(),
				Emp.builder().num(3).role(List.of(Roles.MANAGER).toArray(new Roles[] {})).email("user3").name("tester3").pw(encoder.encode("1234")).build(),
				Emp.builder().num(4).role(new Roles[]{Roles.ADMIN,Roles.USER}).email("user4").name("tester4").pw(encoder.encode("1234")).build()				
				);
		empRepo.saveAll(list);	
		
		String val1=encoder.encode("1234");
		String val2=encoder.encode("1234");
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(encoder.matches("1234", val1));
		System.out.println(encoder.matches("1234", val2));
	}

}







