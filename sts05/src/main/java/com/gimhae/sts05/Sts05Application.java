package com.gimhae.sts05;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sts05Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sts05Application.class, args);
	}

	
	@Autowired
	DataSource dataSource;
	
	@Override
	public void run(String... args) throws Exception {
		try(Connection conn=dataSource.getConnection()){
			conn.createStatement().execute("create table dept100 (deptno int primary key,dname varchar(10),loc varchar(10))");
		}
		
//		Thread.sleep(10000);
//		
//		String msg="https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnld=159";
//		URL url=new URL(msg);
//		URLConnection conn = url.openConnection();
//		try(
//				InputStream is = conn.getInputStream()	
//				){
//			int cnt=-1;
//			while((cnt=is.read())!=-1)
//				System.out.print((char)cnt);
//		}
	}

}















