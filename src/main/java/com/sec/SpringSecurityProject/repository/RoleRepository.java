package com.sec.SpringSecurityProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.SpringSecurityProject.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRolename(String rolename);
}
