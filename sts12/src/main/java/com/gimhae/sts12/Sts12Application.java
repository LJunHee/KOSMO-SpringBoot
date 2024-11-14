package com.gimhae.sts12;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gimhae.sts12.domain.DeptRepo;
import com.gimhae.sts12.domain.EmpRepo;
import com.gimhae.sts12.domain.entity.Dept;
import com.gimhae.sts12.domain.entity.Emp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Sts12Application implements CommandLineRunner {

	@Autowired
	EmpRepo empRepo;
	@Autowired
	DeptRepo deptRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Sts12Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		empRepo.save(Emp.builder().ename("user1").job("worker").hiredate(LocalDateTime.now()).build());
//		empRepo.save(Emp.builder().ename("user2").job("worker").hiredate(LocalDateTime.now()).build());
//		empRepo.save(Emp.builder().ename("user3").job("worker").hiredate(LocalDateTime.now()).build());
//		Iterable<Emp> result = empRepo.findAll();
		
//		List<Emp> list = List.of(
//				Emp.builder().ename("admin").job("tester").hiredate(LocalDateTime.now()).build(),
//				Emp.builder().ename("guest").job("guest").hiredate(LocalDateTime.now()).build(),
//				Emp.builder().ename("user11").job("worker").hiredate(LocalDateTime.now()).build(),
//				Emp.builder().ename("user12").job("worker").hiredate(LocalDateTime.now()).build(),
//				Emp.builder().ename("user13").job("worker").hiredate(LocalDateTime.now()).build()
//				);
		List<Emp> list = new ArrayList<>();
		for(int i=1; i<30; i++) {
			list.add(Emp.builder().ename("user"+1).job("worker").hiredate(LocalDateTime.now()).build());
		}
		empRepo.saveAll(()-> list.iterator());
		
//		result.forEach(bean->list.add(bean));
//		empRepo.findAll().forEach(System.out::println);
//		System.out.println(list);
		
//		Emp result1 = empRepo.findByEname("user1");
		Emp result1 = empRepo.findByEnameAndJob("user2","work");
		System.out.println(result1);
		
//		List<Emp> result2 = empRepo.findByJob("worker");
//		List<Emp> result2 = empRepo.allDesc("es"); //아래 코드와 동일
//		List<Emp> result2 = empRepo.findAllByOrderByEmpnoDesc();
//		List<Emp> result2 = empRepo.findByEnameOrJob("admin", "guest");
		
//		Sort sort  = Sort.by("job").ascending().and(Sort.by("empno")).descending();
//		Pageable page = Pageable.ofSize(10).first().next().next();
//		Sort sort = Sort.by("empno").descending();
//		PageRequest page = PageRequest.of(0,10,sort);
//		Page<Emp> result2 = empRepo.findAll(page);
//		System.out.println(result2.getTotalPages());
//		List<Emp> result3 = result2.toList();
//		System.out.println(result3);
		
		List<Dept> list1=List.of(
				Dept.builder().dname("부서1").loc("test").build()
				,Dept.builder().dname("부서2").loc("test").build()
				);
		deptRepo.saveAll(() -> list1.iterator());
		List<Emp> list2=List.of(
				Emp.builder().ename("user1").job("tester").dept(list1.get(0)).build()
				,Emp.builder().ename("user2").job("tester").dept(list1.get(1)).build()
				,Emp.builder().ename("user3").job("tester").dept(list1.get(1)).build()
				,Emp.builder().ename("user4").job("tester").dept(list1.get(0)).build()
				);
		empRepo.saveAll(() -> list2.iterator());
		
	}

}
