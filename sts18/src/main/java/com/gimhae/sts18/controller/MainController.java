package com.gimhae.sts18.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gimhae.sts18.model.DeptVo;


@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/intro")
	public String intro() {
		return "intro";
	}
	
	@GetMapping("/dept/")
	@ResponseBody
	public List<?> list() {
		return List.of(
				DeptVo.builder().deptno(1111).dname("test1").loc("test").build(),
				DeptVo.builder().deptno(2222).dname("test2").loc("test").build(),
				DeptVo.builder().deptno(3333).dname("test3").loc("test").build(),
				DeptVo.builder().deptno(4444).dname("test4").loc("test").build()
				);
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@ResponseBody
	@GetMapping("/failure")
	public String getMethodName() {
		return "failure page";
	}
	
}









