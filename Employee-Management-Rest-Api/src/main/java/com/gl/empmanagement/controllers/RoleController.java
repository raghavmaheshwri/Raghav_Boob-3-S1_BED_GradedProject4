package com.gl.empmanagement.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.empmanagement.entities.Role;
import com.gl.empmanagement.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("/addrole")
	public String addingRole(@RequestParam("name") String roleName) {

		Role theRole;
		if (roleName != "") {
			theRole = new Role(roleName);
			roleService.save(theRole);
			return roleName + " Added Successfully";
		}
		return "not valid";

	}

	@RequestMapping("/show")
	public List<Role> fetchAllRoles() {
		return this.roleService.findAll();

	}
}
