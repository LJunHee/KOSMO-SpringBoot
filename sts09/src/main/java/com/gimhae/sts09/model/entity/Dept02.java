package com.gimhae.sts09.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dept {
	@Id
	int deptno;
	String dname;
	String loc;
}
