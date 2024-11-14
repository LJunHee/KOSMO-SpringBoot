package com.gimhae.sts12.domain;

import org.springframework.data.repository.CrudRepository;

import com.gimhae.sts12.domain.entity.Dept;

public interface DeptRepo extends CrudRepository<Dept, Integer> {

}