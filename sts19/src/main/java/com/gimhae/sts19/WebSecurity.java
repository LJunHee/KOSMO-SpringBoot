package com.gimhae.sts19;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class WebSecurity {
	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	JwtService jwtService() {
		return new JwtService();
	}

	@Bean
	SecurityFilterChain config(HttpSecurity http) throws Exception {
		http.csrf(token->token.disable());
		http.cors(cors->{cors.configurationSource(getConfigSource());});
		// http.cors(cors->cors.disable());
		http
			.httpBasic().disable()
			.sessionManagement(manager->{
				manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			}) // session사용x
			.addFilterBefore(new TokenFilter(jwtService()), UsernamePasswordAuthenticationFilter.class)
			.authorizeHttpRequests((auth)->{
				auth.requestMatchers("/","/dept/").authenticated();
				auth.requestMatchers("/token","/login/").permitAll();
			})
			.formLogin(form->{
				form.disable();
				form.permitAll();
				form.loginPage("/login2");
				form.loginProcessingUrl("/login2");})
			;
		return http.build();
	}

	private CorsConfigurationSource getConfigSource() {
		CorsConfiguration config=null;
		config=new CorsConfiguration();
		config.setAllowedOrigins(List.of("http://localhost:3000"));
		config.setAllowedHeaders(List.of("Authorization","origin","X-Requested-With","Content-Type"));
		config.setAllowedMethods(List.of("OPTIONS","GET", "POST", "PUT", "DELETE"));
		config.setMaxAge(85600L);
		config.setAllowCredentials(false);
		UrlBasedCorsConfigurationSource source=null;
		source=new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}








