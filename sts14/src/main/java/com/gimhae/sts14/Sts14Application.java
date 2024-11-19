package com.gimhae.sts14;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.gimhae.sts14.model.entity.DeptVo;
import com.gimhae.sts14.service.DeptService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@SpringBootApplication
public class Sts14Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sts14Application.class, args);
	}
	
	@Autowired
	DeptService deptService;
	
	@Override
	public void run(String... args) throws Exception {
		deptService.pushList(DeptVo.builder().dname("tester01").loc("서울").build());
		deptService.pushList(DeptVo.builder().dname("tester02").loc("대전").build());
		deptService.pushList(DeptVo.builder().dname("tester03").loc("대구").build());
		deptService.pushList(DeptVo.builder().dname("tester04").loc("부산").build());
	}
	
	@CrossOrigin(origins = {"http://192.168.54.72:3000",
	                        "http://localhost:3000",
	                        "http://127.0.0.1"
							}, methods = RequestMethod.GET)
	@GetMapping("/dept/")
	public ResponseEntity<?> getMethodName() {
		return ResponseEntity.ok(deptService.getList());
	}
	
	@CrossOrigin(origins = {"http://192.168.54.72:3000",
				            "http://localhost:3000",
				            "http://127.0.0.1"
							}, methods = RequestMethod.POST)
	@PostMapping("/dept/")
	public ResponseEntity<?> add(@RequestBody DeptVo bean) {
		try {
			deptService.pushList(bean);
			return ResponseEntity.ok().build();			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@CrossOrigin
	@GetMapping("/dept/{deptno}")
	public Optional<DeptVo> getMethodName(@PathVariable int deptno) {
		return deptService.getList(deptno);
	}
	
	

	
	
	

}
