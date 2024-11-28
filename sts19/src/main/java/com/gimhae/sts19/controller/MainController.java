package com.gimhae.sts19.controller;

import java.net.HttpCookie;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gimhae.sts19.JwtService;


@Controller
public class MainController {
	@Autowired
	JwtService jwtService;

	@ResponseBody
	@PostMapping("/login/")
	public String getToken(String id,String pw) {	//HttpCookie cookie) {
//		cookie.setValue(jwtService.createToken("user01"));
//		cookie.setMaxAge(System.currentTimeMillis()+6000);
//		cookie.setDomain("http://localhost:8080/");
		if(id.equals("user01")&& pw.equals("1234"))
			return jwtService.createToken(id);
		return null;
	}
	
	@ResponseBody
	@GetMapping("/dept/")
	public List<Map<String, String>> list() {
		return List.of(
				Map.of("deptno","1111","dname","user1","loc","test"),
				Map.of("deptno","2222","dname","user2","loc","test"),
				Map.of("deptno","3333","dname","user3","loc","test"),
				Map.of("deptno","4444","dname","user4","loc","test"),
				Map.of("deptno","5555","dname","user5","loc","test"),
				Map.of("deptno","6666","dname","user6","loc","test"),
				Map.of("deptno","7777","dname","user7","loc","test")
				);
	}
//	@ResponseBody
//	@PostMapping("/login")
//	public String postLogin() {
//		return "post login";
//	}
	
}








