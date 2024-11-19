package com.gimhae.sts14.model;

import org.springframework.data.repository.CrudRepository;

import com.gimhae.sts14.model.entity.Dept;

public interface DeptRepo extends CrudRepository<Dept, Integer> {
	
}
