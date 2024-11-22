package com.gimhae.sts15.service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	final Key key=Keys.secretKeyFor(SignatureAlgorithm.HS256);

	//발급
	public String createToken(String email) {
		String token=Jwts.builder()
		.addClaims(Map.of("email",email))
		.setExpiration(new Date(System.currentTimeMillis()+1000*60))
		.signWith(key)
		.compact();
		return token;
	}

	// 열람
	public String getAuthEmail(String token) {
		JwtParser parser = Jwts.parserBuilder()
							.setSigningKey(key)
							.build();
		String email=(String) parser.parseClaimsJws(token).getBody().get("email");
		return email;
	}
}






