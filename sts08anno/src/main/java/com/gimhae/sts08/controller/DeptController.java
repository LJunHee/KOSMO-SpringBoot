package com.gimhae.sts08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gimhae.sts08.model.DeptVo;
import com.gimhae.sts08.service.DeptService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/dept")
@RequiredArgsConstructor
public class DeptController {
	final DeptService deptService;
	
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("alist", deptService.getList());
		return "list";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute DeptVo bean) {
		deptService.add(bean);
		
		return "redirect:./";
	}
	
	@GetMapping("/{deptno}")
	public String getMethodName(@PathVariable int deptno,Model model) {
		model.addAttribute("bean", deptService.getOne(deptno));
		return "detail";
	}
	
	
}
