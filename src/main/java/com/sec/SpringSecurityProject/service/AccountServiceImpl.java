package com.sec.SpringSecurityProject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sec.SpringSecurityProject.entities.Role;
import com.sec.SpringSecurityProject.entities.User;
import com.sec.SpringSecurityProject.repository.RoleRepository;
import com.sec.SpringSecurityProject.repository.UserRepository;

import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	

	
	public User addNewUser(User user) {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		return userRepository.save(user);
		
	}

	
	public Role addNewRole(Role role) {
		return roleRepository.save(role);
	}

	
	public void addRoleToUser(String username, String rolename) {
		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByRolename(rolename);
		user.getRoles().add(role);
		
	}

	
	public User loadUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	
	public List<User> listUsers() {
		return userRepository.findAll();
	}

}
