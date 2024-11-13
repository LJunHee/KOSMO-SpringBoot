package com.gimhae.sts06;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gimhae.sts06.model.DeptService;
import com.gimhae.sts06.model.DeptVo;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/dept")
public class DeptController {
	final DeptService deptService;

	@GetMapping("/")
	public List<DeptVo> list() {
		return deptService.pullList();
	}
	
	@PostMapping("/")
	public ResponseEntity<?> add(@ModelAttribute DeptVo bean) {
		try {
		deptService.putList(bean);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
}









