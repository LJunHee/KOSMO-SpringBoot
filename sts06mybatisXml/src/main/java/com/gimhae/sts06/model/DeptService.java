package com.gimhae.sts06.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeptService {
	final SqlSession sqlSession;
	
	public List<DeptVo> pullList(){
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		log.debug(deptDao.toString());
		return deptDao.selectAll();
	}
	
	public void putList(DeptVo bean) {
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		log.debug(bean.toString());
		deptDao.insertOne(bean);
	}
}








