package com.gimhae.sts15.model;

import org.springframework.data.repository.CrudRepository;

import com.gimhae.sts15.model.entity.Dept;

public interface DeptRepo extends CrudRepository<Dept, Integer> {

}
