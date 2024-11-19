package com.gimhae.sts14.model.entity;

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
	String dname,loc;
	
	public Dept deptBuild() {
		return Dept.builder()
				.dname(dname)
				.loc(loc)
				.build();
	}
}
