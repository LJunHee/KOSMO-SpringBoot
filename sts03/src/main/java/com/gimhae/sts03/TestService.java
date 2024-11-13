package com.gimhae.sts03;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	@Autowired
	DataSource dataSource;
	
	public void test1() {
		System.out.println(dataSource);
	}
	
}
