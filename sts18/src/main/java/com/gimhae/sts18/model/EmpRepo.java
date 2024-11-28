package com.gimhae.sts18.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gimhae.sts18.model.entity.Emp;

public interface EmpRepo extends CrudRepository<Emp, Integer> {
	Optional<Emp> findByEmail(String email);
}
