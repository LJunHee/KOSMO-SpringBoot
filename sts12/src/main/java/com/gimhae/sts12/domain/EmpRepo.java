package com.gimhae.sts12.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gimhae.sts12.domain.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer> {
//public interface EmpRepo extends CrudRepository<Emp, Integer>{
	
//	Optional<Emp> findByEname(String name);
	Emp findByEname(String name);

//	@Query("select a from Emp a order by a.empno desc")
	@Query("select a from Emp a where a.job like %?1% order by a.empno desc")
	List<Emp> allDesc(String job);
	List<Emp> findAllByOrderByEmpnoDesc();
	List<Emp> findByJob(String job);
	Emp findByEnameAndJob(String name, String job);
	List<Emp> findByEnameOrJob(String name, String job);
	
}
										