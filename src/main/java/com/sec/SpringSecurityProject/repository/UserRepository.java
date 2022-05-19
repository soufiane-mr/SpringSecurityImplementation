package com.sec.SpringSecurityProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.SpringSecurityProject.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);

}
