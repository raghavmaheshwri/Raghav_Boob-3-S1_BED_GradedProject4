package com.gl.empmanagement.service;

import java.util.List;

import com.gl.empmanagement.entities.User;

public interface UserService {

	public void save(User theUser);

	public List<User> getAllUser();

}
