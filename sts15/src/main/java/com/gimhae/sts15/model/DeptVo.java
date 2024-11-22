package com.gimhae.sts15.model;

import com.gimhae.sts15.model.entity.Dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeptVo {
	int deptno;
	String dname;
	String loc;
	public Dept toEntity() {
		return Dept.builder().deptno(deptno).dname(dname).loc(loc).build();
	}
}
