package com.gimhae.sts15.model.entity;

import com.gimhae.sts15.model.DeptVo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Dept {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int deptno;
	String dname;
	String loc;
	public DeptVo toVo() {
		return DeptVo.builder().deptno(deptno).dname(dname).loc(loc).build();
	} 
}









