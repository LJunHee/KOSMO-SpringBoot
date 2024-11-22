package com.gimhae.sts15.model;

import com.gimhae.sts15.model.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersVo {	// UsersRequest, UsersResponse
	int num;
	String email,pw,name;
	
	public Users toEntity() {
		return Users.builder().num(num).email(email).pw(pw).name(name).build();
	}
}
