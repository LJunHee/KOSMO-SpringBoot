package com.gimhae.sts15;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.gimhae.sts15.model.DeptRepo;
import com.gimhae.sts15.model.DeptVo;
import com.gimhae.sts15.model.UsersRepo;
import com.gimhae.sts15.model.UsersVo;
import com.gimhae.sts15.service.JwtService;

@SpringBootApplication
public class Sts15Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sts15Application.class, args);
	}

	@Autowired
	UsersRepo usersRepo;
	@Autowired
	DeptRepo deptRepo;
	
	@Override
	public void run(String... args) throws Exception {
		List<UsersVo> userList = List.of(
		UsersVo.builder().email("user1@localhost").pw("1234").name("user1").build(),
		UsersVo.builder().email("user2@localhost").pw("1234").name("user2").build()
		);
		userList.forEach(vo -> usersRepo.save(vo.toEntity()));
		
		List.of(
				DeptVo.builder().dname("test1").loc("test").build(),
				DeptVo.builder().dname("test2").loc("test").build(),
				DeptVo.builder().dname("test3").loc("test").build(),
				DeptVo.builder().dname("test4").loc("test").build()
				).forEach(vo->deptRepo.save(vo.toEntity()));
		
		String token=jwtService.createToken("user1@localhost");
		System.out.println("token:"+token);
		String email=jwtService.getAuthEmail(token);
		System.out.println("email:"+email);
	}

	@Autowired
	JwtService jwtService;
}











