package com.gimhae.sts19;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenFilter extends OncePerRequestFilter{
	final JwtService jwtService;

	@Override
	protected void doFilterInternal(
			HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		if(req.getRequestURI().startsWith("/token")) {
			chain.doFilter(req, resp);return ;}
		if(req.getRequestURI().startsWith("/login")) {
			chain.doFilter(req, resp);return ;}
		if(req.getMethod().equals("OPTIONS")) {
			chain.doFilter(req, resp);
			return ;}
		
		String auth=req.getHeader("Authorization");
		if(auth==null||auth.isEmpty()||!auth.startsWith("Bearer ")) {
			resp.sendError(405);
			return;
		}
		auth=auth.replace("Bearer ", "");
		System.out.println("->            "+auth);
		String username = jwtService.getAuthEmail(auth);
		// username 유효하면
		if("user01".equals(username)) {
			SecurityContext ctxt = SecurityContextHolder.getContext();
			ctxt.setAuthentication(new UsernamePasswordAuthenticationToken(
					username,null,List.of(new SimpleGrantedAuthority("USER"))
					));
			chain.doFilter(req, resp);
		}else {
			resp.sendError(403);
		}
	}


}
