package com.gimhae.sts15.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gimhae.sts15.model.entity.Users;

public interface UsersRepo extends CrudRepository<Users, Integer> {
		Optional<Users> findByEmailAndPw(String email,String pw);

		Users findByEmail(String email);
}
