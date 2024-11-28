package com.gimhae.sts17;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import jakarta.servlet.FilterChain;

@Configuration
@EnableWebSecurity
public class WebSecrity {

	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http
//					.authorizeHttpRequests()
//					.requestMatchers("/dept/","/emp/").authenticated()	
//					.anyRequest().anonymous()
//				.and()
//					.formLogin()
//				.and()
//					.logout()
//				.and()
//				.build();
				.authorizeHttpRequests(reg->{
					reg.requestMatchers("/").anonymous();
					reg.anyRequest().authenticated();
				})
				.formLogin().and()
//				.formLogin(login->login.loginPage("/login").permitAll())
				.build();
	}
	
	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService getUserDetails() {
		UserDetails user1,user2,user3=null;
		String pw="1234";
		pw=encoder().encode(pw);
		user1=new User("user01", pw, List.of(new SimpleGrantedAuthority("USER")));
		user2=new User("user02", pw, List.of(new SimpleGrantedAuthority("USER")));
		user3=new User("user03", pw, List.of(new SimpleGrantedAuthority("USER")));
		return new InMemoryUserDetailsManager(user1,user2,user3);
	}
	
}
