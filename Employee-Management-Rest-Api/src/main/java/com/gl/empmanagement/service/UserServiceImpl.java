package com.gl.empmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.empmanagement.entities.User;
import com.gl.empmanagement.repository.RoleRepository;
import com.gl.empmanagement.repository.UserRepository;

@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void save(User theUser) {
		userRepository.save(theUser);

	}

	@Override
	public List<User> getAllUser() {
		List<User> theUsers = userRepository.findAll();
		return theUsers;
	}

}
