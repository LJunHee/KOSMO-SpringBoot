package com.gimhae.sts19;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DeptUserDetail implements UserDetailsService {
	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Map<String, String>> data = List.of(
				Map.of("id","user01","pw",encoder.encode("1234")),
				Map.of("id","user02","pw",encoder.encode("1234")),
				Map.of("id","user03","pw",encoder.encode("1234")),
				Map.of("id","user04","pw",encoder.encode("1234"))				
				);
				
				
		for(Map<String, String> bean:data) {
			if(bean.get("id").equals(username))
				return User.builder()
						.username(bean.get("id"))
						.password(bean.get("pw"))
						.authorities("USER")
						.build();
		}
		return User.builder().build();
	}

}
