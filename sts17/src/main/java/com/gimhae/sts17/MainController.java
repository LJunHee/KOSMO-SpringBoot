package com.gimhae.sts17;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index page";
	}

	@GetMapping("/dept/")
	public String list() {
		return "dept list page";
	}


	@GetMapping("/dept/add")
	public String add() {
		return "add dept page";
	}

	@GetMapping("/emp/")
	public String list2() {
		return "emp list page";
	}


	@GetMapping("/emp/add")
	public String add2() {
		return "add emp page";
	}
	
}
