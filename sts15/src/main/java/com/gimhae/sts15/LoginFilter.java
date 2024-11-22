package com.gimhae.sts15;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("before filter...");
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		System.out.println(req.getRequestURI());
		res.setHeader("Access-Control-Allow-Credentials", "true");
		if(req.getRequestURI().startsWith("/dept")) {
			HttpSession session = req.getSession();
			if(session.getAttribute("result")!=null) {
				chain.doFilter(request, response);
			}else {
				res.sendError(401);
			}
		}else{
			chain.doFilter(request, response);			
		}
		System.out.println("after filter...");
	}

}










