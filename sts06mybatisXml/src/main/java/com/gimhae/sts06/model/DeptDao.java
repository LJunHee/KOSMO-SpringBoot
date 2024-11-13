package com.gimhae.sts06.model;

import java.util.List;

public interface DeptDao {

	public List<DeptVo> selectAll();
	public DeptVo selectOne(int key);
	public void insertOne(DeptVo bean);
	public int updateOne(DeptVo bean);
	public int deleteOne(int key);
}
