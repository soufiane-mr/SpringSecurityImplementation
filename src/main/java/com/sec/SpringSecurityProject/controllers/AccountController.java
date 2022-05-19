package com.sec.SpringSecurityProject.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sec.SpringSecurityProject.entities.Role;
import com.sec.SpringSecurityProject.entities.User;
import com.sec.SpringSecurityProject.service.AccountService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/users")
    public List<User> listUsers(){
        return accountService.listUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
      return accountService.addNewUser(user);
    }

    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role){
      return accountService.addNewRole(role);
    }

    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
       accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRolename());
    }

    @Data
    class RoleUserForm{
        private String username;
        private String rolename;
    }
}
