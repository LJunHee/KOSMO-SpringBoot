package com.gimhae.sts15;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gimhae.sts15.model.UsersRepo;
import com.gimhae.sts15.model.entity.Users;
import com.gimhae.sts15.service.JwtService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//@Component
public class LoginFilter extends OncePerRequestFilter{
	@Autowired
	JwtService jwtService;
	@Autowired
	UsersRepo usersRepo;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		String token=req.getHeader("Authorization");
		System.out.println("->"+token);
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		res.setHeader("Access-Controll-Allow-Headers", "Authorization, origin, x-requested-with");
		res.setHeader("Access-Control-Allow-Methods", "OPTIONS, PATCH, PUT, GET, POST");
		res.setHeader("Access-Control-Max-Age", "5000");
	if(req.getRequestURI().startsWith("/dept")) {
		try {
			if(!token.startsWith("Bearer ")) throw new RuntimeException();
			token=token.split(" ")[1];
			String email=jwtService.getAuthEmail(token);
			Users user=usersRepo.findByEmail(email);
			chain.doFilter(req, res);
		}catch (Exception e) {
			res.sendError(401);
		}
	}else{
		chain.doFilter(req, res);			
	}
	System.out.println("after filter...");
	}

}










