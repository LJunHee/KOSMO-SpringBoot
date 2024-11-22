package com.gimhae.sts15.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gimhae.sts15.model.UsersRepo;
import com.gimhae.sts15.model.UsersVo;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/login/")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.GET,RequestMethod.POST})
public class LoginController {
	final UsersRepo usersRepo;
	ResponseEntity<?> resp;

	@PostMapping("")
	public ResponseEntity<?> login(String id,String pw,HttpSession session) {
		usersRepo.findByEmailAndPw(id, pw).ifPresentOrElse(entity -> {
			UsersVo bean = entity.toVo();
//			resp=ResponseEntity.ok(bean);
			resp=ResponseEntity.ok().body(bean);
			session.setAttribute("result", true);
			session.setAttribute("num", bean.getNum());
			log.debug("로그인됨");
		}, () -> {
			resp=ResponseEntity.badRequest().build();
		});
		return resp;
	}
	@GetMapping("logout")
	public ResponseEntity<?> getMethodName(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok().build();
	}
	
	
}







