package com.gimhae.sts12.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int empno;
	@Column(length = 10)
	String ename;
	@Column(length = 10)
	String job;
	LocalDateTime hiredate;
	
//	@Column(nullable = true)
	@ManyToOne(fetch = FetchType.LAZY)//
	@JoinColumn(name = "deptno")
	Dept deptno;
}








