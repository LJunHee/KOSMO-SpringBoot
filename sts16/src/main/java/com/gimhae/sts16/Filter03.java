package com.gimhae.sts16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component
//@Order(1)
public class Filter03 extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		System.out.println("filter run...");
			Enumeration<String> names = request.getHeaderNames();
			while(names.hasMoreElements())
				System.out.println(names.nextElement());
			chain.doFilter(request, response);
		
	}

}
