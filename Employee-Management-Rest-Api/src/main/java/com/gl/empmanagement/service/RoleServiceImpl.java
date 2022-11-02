package com.gl.empmanagement.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gl.empmanagement.entities.Role;
import com.gl.empmanagement.repository.RoleRepository;

@Repository
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Transactional
	public void save(Role theRole) {
		roleRepository.save(theRole);
	}

	@Override
	public List<Role> findAll() {
		List<Role> theRoles = this.roleRepository.findAll();
		return theRoles;

	}
}
