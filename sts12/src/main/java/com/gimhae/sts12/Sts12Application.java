package com.gimhae.sts12;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;

import com.gimhae.sts12.domain.DeptRepo;
import com.gimhae.sts12.domain.EmpRepo;
import com.gimhae.sts12.domain.entity.Dept;
import com.gimhae.sts12.domain.entity.Emp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Sts12Application implements CommandLineRunner{
	@Autowired
	DeptRepo deptRepo;
	@Autowired
	EmpRepo empRepo;

	public static void main(String[] args) {
		SpringApplication.run(Sts12Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		empRepo.save(Emp.builder().ename("user1").job("tester").hiredate(LocalDateTime.now()).build());
//		empRepo.save(Emp.builder().ename("user2").job("tester").hiredate(LocalDateTime.now()).build());
//		empRepo.save(Emp.builder().ename("user3").job("tester").hiredate(LocalDateTime.now()).build());
//		Iterable<Emp> result = empRepo.findAll();
		
//		List<Emp> list=List.of(
//				Emp.builder().ename("admin").job("tester").hiredate(LocalDateTime.now()).build(),
//				Emp.builder().ename("guest").job("guest").hiredate(LocalDateTime.now()).build(),
//				Emp.builder().ename("user1").job("worker").hiredate(LocalDateTime.now()).build(),
//				Emp.builder().ename("user2").job("worker").hiredate(LocalDateTime.now()).build(),
//				Emp.builder().ename("user3").job("worker").hiredate(LocalDateTime.now()).build()
//				);
//		List<Emp> list=new ArrayList<>();
//		for(int i=1; i<30; i++) {
//			list.add(Emp.builder().ename("user"+i).job("worker").hiredate(LocalDateTime.now()).build());
//		}
//		empRepo.saveAll(() -> list.iterator());
		
//		result.forEach(bean->list.add(bean));
//		empRepo.findAll().forEach(System.out::println);
//		System.out.println(list);
		
		//		Emp result1 = empRepo.findByEname("user1");
//		Emp result1=empRepo.findByEnameAndJob("user2", "work");
//		System.out.println(result1);
//		List<Emp> result2 = empRepo.findByJob("worker");
//		List<Emp> result2 = empRepo.allDesc("es");
//		List<Emp> result2 = empRepo.findByEnameOrJob("admin", "guest");
//		Sort sort=Sort.by("job").ascending().and(Sort.by("empno")).descending();
//		Pageable page=Pageable.ofSize(10).first().next().next();
//		Pageable page=Pageable.ofSize(10).withPage(1);
//		Sort sort=Sort.by("empno").descending();
//		PageRequest page=PageRequest.of(0,10,sort);
//		Page<Emp> result2 = empRepo.findAll(page);
//		System.out.println(result2.getTotalPages());
//		List<Emp> result3 = result2.toList();
//		System.out.println(result3);
		
		List<Dept> list1=List.of(
				Dept.builder().dname("부서1").location("test").build()
				,Dept.builder().dname("부서2").location("test").build()
				);
		deptRepo.saveAll(() -> list1.iterator());
		List<Emp> list2=List.of(
				Emp.builder().ename("user1").job("tester").deptno(list1.get(0)).build()
				,Emp.builder().ename("user2").job("tester").deptno(list1.get(1)).build()
				,Emp.builder().ename("user3").job("tester").deptno(list1.get(1)).build()
				,Emp.builder().ename("user4").job("tester").deptno(list1.get(0)).build()
				);
		empRepo.saveAll(() -> list2.iterator());
		
	}

}








