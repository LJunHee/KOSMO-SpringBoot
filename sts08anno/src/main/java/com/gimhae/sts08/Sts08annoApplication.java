package com.gimhae.sts08;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.gimhae.sts08.model")
@SpringBootApplication
public class Sts08annoApplication implements CommandLineRunner{
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(Sts08annoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try(
				Connection conn=dataSource.getConnection();
				){
			Statement stmt=conn.createStatement();
			stmt.execute("create table dept(deptno int primary key, dname varchar(10),loc varchar(10))");
			stmt=conn.createStatement();
			stmt.executeUpdate("insert into dept values (%d,'%s','%s')".formatted(1111,"test1","test2"));
			stmt=conn.createStatement();
			stmt.executeUpdate("insert into dept values (%d,'%s','%s')".formatted(2222,"test3","test4"));
			stmt=conn.createStatement();
			stmt.executeUpdate("insert into dept values (%d,'%s','%s')".formatted(3333,"test5","test6"));
			stmt=conn.createStatement();
			stmt.executeUpdate("insert into dept values (%d,'%s','%s')".formatted(4444,"test7","test8"));
		}
	}

}
