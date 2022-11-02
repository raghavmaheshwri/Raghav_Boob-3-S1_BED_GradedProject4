package com.gl.empmanagement.controllers;

import java.util.Base64.Encoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.empmanagement.entities.Role;
import com.gl.empmanagement.entities.User;
import com.gl.empmanagement.repository.RoleRepository;
import com.gl.empmanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping("/add")
	public User saveUserinDb(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("roleid") int[] theRoleid) {

		User theUser;
		theUser = new User(username, bCryptPasswordEncoder.encode(password));

		for (int i = 0; i < theRoleid.length; i++) {
			Role role[] = new Role[3];
			role[i] = roleRepository.findById(theRoleid[i]).get();
			theUser.addRole(role[i]);
		}

		userService.save(theUser);

		return theUser;

	}

	@RequestMapping("/show")
	public List<User> findAllUser() {
		return userService.getAllUser();
	}

}
