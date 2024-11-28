package com.gimhae.sts18.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gimhae.sts18.service.JwtService;

//@Configuration
//@EnableWebSecurity
public class WebJwtSecurity {
	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	JwtService getJwtService() {
		return new JwtService();
	};

	@Bean
	SecurityFilterChain config(HttpSecurity http) throws Exception {
		http
			.httpBasic(basic->basic.disable())
			.csrf(csrf->csrf.disable())
			.cors(cors->cors.disable())
			.sessionManagement(t -> {
				t.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			})
			.authorizeHttpRequests(req->{
				req.requestMatchers("/","/intro","/token").permitAll()
				.anyRequest().authenticated();
			})
			.addFilterBefore(new LoginFilter(getJwtService()), UsernamePasswordAuthenticationFilter.class)
			.formLogin(form->form.successHandler(null));
		return http.build();
	}
}









