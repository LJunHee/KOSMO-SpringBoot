package com.gimhae.sts03;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sts03Application implements CommandLineRunner{

	public static void main(String[] args) {
		ApplicationContext sc;
		sc=SpringApplication.run(Sts03Application.class, args);
//		Machine remote = ac.getBean(Machine.class);
//		remote.on();
//		remote.work();
//		remote.off();
		TestService service=sc.getBean(TestService.class);
		service.test1();
	}

	@Bean
	public Machine getMachine() {
		return new Tv();
	}

	@Override
	public void run(String... args) throws Exception {
		Machine remote=this.getMachine();
		remote.on();
		remote.work();
		remote.off();
	}
}









