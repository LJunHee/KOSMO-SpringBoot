package com.gimhae.sts16;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	@Override
		public void addCorsMappings(CorsRegistry reg) {
			reg.addMapping("/dept/")
				.allowedOrigins("http://localhost:3000")
				.allowedMethods("OPTIONS","GET","POST","PUT","DELETE")
				.allowCredentials(true);
		}
	
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry reg) {
//		reg.jsp("/WEB-INF/views/", ".jsp");
//	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry reg) {
//		reg.addResourceHandler("/test/**").addResourceLocations("classpath:/tests");
//	}


//	@Bean
//	FilterRegistrationBean filter(){
//		FilterRegistrationBean bean=new FilterRegistrationBean();
//		bean.setFilter(new Filter02());
//		bean.addUrlPatterns("/");
//		bean.setOrder(2);
//		return bean;
//	}
	
	@Bean
	FilterRegistrationBean filter2(){
		FilterRegistrationBean bean=new FilterRegistrationBean();
		bean.setFilter(new Filter03());
		bean.addUrlPatterns("/dept/");
		bean.setOrder(1);
		return bean;
	}
}
