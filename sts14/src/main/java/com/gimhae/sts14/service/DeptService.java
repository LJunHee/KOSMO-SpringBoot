package com.gimhae.sts14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimhae.sts14.model.DeptRepo;
import com.gimhae.sts14.model.entity.Dept;
import com.gimhae.sts14.model.entity.DeptVo;

@Service
public class DeptService {
	@Autowired
	DeptRepo deptRepo;
	
	public Iterable<Dept> getList() {
		return deptRepo.findAll();
	}
	
	public void pushList(DeptVo bean) {
		deptRepo.save(bean.deptBuild());
	}
	
}
