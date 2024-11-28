package com.gimhae.sts18.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gimhae.sts18.model.EmpRepo;
import com.gimhae.sts18.model.entity.Emp;

@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	EmpRepo empRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 데이터 베이스검색 파라미터의 아이디값에서 해당 user 
		Optional<Emp> opt = empRepo.findByEmail(username);
		if(opt.isEmpty()) return null;
		Emp emp = opt.get();
		return User.builder()
				.username(emp.getEmail())
				.password(emp.getPw())
				.roles(
						Arrays.asList(emp.getRole()).stream()
						.map(role->role.name())
						.toList()
						.toArray(new String[] {}))
				.build();
	}

}
