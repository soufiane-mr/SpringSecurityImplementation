package com.sec.SpringSecurityProject.service;

import java.util.List;

import com.sec.SpringSecurityProject.entities.Role;
import com.sec.SpringSecurityProject.entities.User;

public interface AccountService {
	User addNewUser(User user);
	Role addNewRole(Role role);
	void addRoleToUser(String username, String rolename);
	User loadUserByUsername(String username);
	List<User> listUsers();

}
