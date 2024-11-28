package com.gimhae.sts16;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

//@Component 
//@WebFilter("/**")
public class Filter01 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try(java.io.OutputStream out=response.getOutputStream()){
			out.write("filter01...".getBytes());
			chain.doFilter(request, response);
		}
	}

}
