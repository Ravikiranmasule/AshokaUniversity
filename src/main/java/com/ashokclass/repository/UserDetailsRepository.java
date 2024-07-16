package com.ashokclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokclass.entity.UserDetailsEntity;

public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Integer> {
	public UserDetailsEntity findByUserEmail(String email);
	public UserDetailsEntity findByUserEmailAndUserPassword(String email,String password);

}
