package com.gimhae.sts08.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gimhae.sts08.model.DeptDao;
import com.gimhae.sts08.model.DeptVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptService {
	final DeptDao deptDao;
	
	public List<DeptVo> getList(){
		return deptDao.selectAll();
	}

	public void add(DeptVo bean) {
		deptDao.insertOne(bean);
	}

	public DeptVo getOne(int deptno) {
		return deptDao.selectOne(deptno);
	}
}
