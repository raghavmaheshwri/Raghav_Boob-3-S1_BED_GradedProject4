package com.gl.empmanagement.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController()
public class HelloController {

	@RequestMapping("/")
	public String hello() {
		return "Welcome to Emplyoee Management Rest API";
	}

	@RequestMapping("/403")
	public String error403(Principal user) {

		return "Hi " + user.getName() + ", you do not have permission to access this page!";
	}
}
