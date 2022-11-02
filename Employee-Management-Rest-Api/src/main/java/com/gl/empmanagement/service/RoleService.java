package com.gl.empmanagement.service;

import java.util.List;
import com.gl.empmanagement.entities.Role;

public interface RoleService {

	public List<Role> findAll();

	public void save(Role theRole);

}
