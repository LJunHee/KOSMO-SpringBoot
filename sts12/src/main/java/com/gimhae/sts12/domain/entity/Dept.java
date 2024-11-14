package com.gimhae.sts12.domain.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	int deptNo;
	@Column(length = 10, nullable = false, unique = true)
	String dname;
	@Column(name = "loc")
	String location;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "deptno")
	List<Emp> emps;
}








