package com.gl.empmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.empmanagement.entities.Employee;
import com.gl.empmanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/show")
	public List<Employee> showEmployee() {
		return this.employeeService.findAll();

	}

	@PostMapping("/add")
	public String addEmployee(@RequestParam("firstname") String FirstName, @RequestParam("lastname") String LastName,
			@RequestParam("email") String email) {

		Employee employee;

		employee = new Employee(FirstName, LastName, email);
		employeeService.save(employee);

		return "Employee Added Succesfully";

	}

	@GetMapping("/{id}")
	public Employee findEmployeeByid(@PathVariable("id") int theid) {
		return this.employeeService.findById(theid);
	}

	@PutMapping("/update/{id}")
	public Employee upldateEmployee(@PathVariable("id") int theid, @RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName, @RequestParam("email") String email) {
		Employee theEmployee;
		theEmployee = employeeService.findById(theid);
		theEmployee.setFirstname(firstName);
		theEmployee.setLastname(lastName);
		theEmployee.setEmail(email);

		employeeService.save(theEmployee);
		return theEmployee;
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") int theid) {
		employeeService.deleteById(theid);
		return "Deleted employee id - " + theid;
	}

	@RequestMapping("/search/{firstname}")
	public List<Employee> findEmployeeById(@PathVariable("firstname") String fName) {
		return this.employeeService.findAllByFirstName(fName);
	}

	@RequestMapping("/sort")
	public List<Employee> orderByFnme(@RequestParam("order") String orderBy) {
		return this.employeeService.OrderbyFirstName(orderBy);

	}
}
