package com.gimhae.sts18.config;

import java.net.http.HttpRequest;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {

	@Bean
	SecurityFilterChain config(HttpSecurity http) throws Exception {
		
		return http
				.httpBasic().disable() // API service
//				.cors(t -> {})
				.authorizeHttpRequests(
						reg->{
//							reg.requestMatchers("/","/h2","/h2/**").anonymous();
//							reg.anyRequest().authenticated();
//							reg.requestMatchers(PathRequest.toH2Console()).permitAll();
							reg.requestMatchers("/dept/","/dept/**").hasRole("ADMIN");
							reg.requestMatchers("/intro").hasRole("USER");
							reg.requestMatchers("/").permitAll();
							reg.anyRequest().anonymous();
						}
				)
				.formLogin(form->{
					form.loginPage("/login");
					form.failureUrl("/failure");
					form.usernameParameter("email");
				})
//				<input type="hidden" th:name = "${_csrf.parameterName}" th:value="${_csrf.token}" />
//				.csrf(Customizer.withDefaults())
//				.csrf().disable()
				.csrf(token->token.disable())
				.build();
	}
	
	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}








