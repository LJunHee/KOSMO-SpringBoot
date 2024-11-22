package com.gimhae.sts15.model.entity;

import com.gimhae.sts15.model.UsersVo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int num;
	String email;
	String pw;
	String name;
	
	public UsersVo toVo() {
		return UsersVo.builder().num(num).email(email).pw(pw).name(name).build();
	}
}







