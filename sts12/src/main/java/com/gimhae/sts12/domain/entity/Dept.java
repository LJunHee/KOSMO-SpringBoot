package com.gimhae.sts12.domain.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Dept {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int deptno;
	String dname;
	String loc;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "dept")
	List<Emp> emps;
}








