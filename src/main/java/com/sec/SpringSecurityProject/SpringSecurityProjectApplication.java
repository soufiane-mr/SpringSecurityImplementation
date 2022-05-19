package com.sec.SpringSecurityProject;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sec.SpringSecurityProject.entities.Role;
import com.sec.SpringSecurityProject.entities.User;
import com.sec.SpringSecurityProject.service.AccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityProjectApplication.class, args);
	}
	@Bean
	PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args -> {
			accountService.addNewRole(new Role(null, "USER"));
			accountService.addNewRole(new Role(null, "ADMIN"));
			accountService.addNewRole(new Role(null, "ACCOUNT_MANAGER"));
			
			accountService.addNewUser(new User(null, "user1", "123456", new ArrayList<>()));
			accountService.addNewUser(new User(null, "admin", "123456", new ArrayList<>()));
			accountService.addNewUser(new User(null, "user2", "123456", new ArrayList<>()));
			accountService.addNewUser(new User(null, "user3", "123456", new ArrayList<>()));
			
			accountService.addRoleToUser("user1", "USER");
			accountService.addRoleToUser("admin", "USER");
			accountService.addRoleToUser("admin", "ADMIN");
			accountService.addRoleToUser("user2", "ACCOUNT_MANAGER");
			accountService.addRoleToUser("user3", "ACCOUNT_MANAGER");


		};
	}

}
