package com.gl.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.empmanagement.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
