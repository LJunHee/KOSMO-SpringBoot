package com.gimhae.sts08.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface DeptDao {

	@Select("select * from dept order by deptno")
	List<DeptVo> selectAll();

	@Insert("insert into dept values (#{deptno},#{dname},#{loc})")
	void insertOne(DeptVo bean);

	@Select("select * from dept where deptno=#{deptno}")
	DeptVo selectOne(int deptno);

}
