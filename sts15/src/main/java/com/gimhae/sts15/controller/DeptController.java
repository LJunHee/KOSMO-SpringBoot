package com.gimhae.sts15.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gimhae.sts15.model.DeptRepo;
import com.gimhae.sts15.model.DeptVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;



@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dept/")
//@CrossOrigin(origins = "http://*",methods = {RequestMethod.GET,RequestMethod.POST},exposedHeaders = {"Authorization", "Content-Type"})
public class DeptController {
	final DeptRepo deptRepo;
	ResponseEntity resp=ResponseEntity.status(401).build();
	@GetMapping("")
	public ResponseEntity<?> list(HttpSession session,HttpServletRequest req) {
		System.out.println("->"+req.getHeader("Authorization"));
		log.debug("login ok");
		List<Object> list = new ArrayList<>();
		deptRepo.findAll().forEach(entity->list.add(entity.toVo()));
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("")
	public ResponseEntity<?> add(@RequestBody DeptVo bean,HttpSession session) {
		if(session.getAttribute("result")==null) return resp;
		deptRepo.save(bean.toEntity());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("{deptno}")
	public ResponseEntity<?> detail(@PathVariable int deptno,HttpSession session) {
		if(session.getAttribute("result")==null) return resp;
		deptRepo.findById(deptno).ifPresentOrElse(t -> {
			resp=ResponseEntity.ok().body(t.toVo());
		}, ()->{
			resp=ResponseEntity.badRequest().build();
		});
		return resp;
	}
	
	
}




