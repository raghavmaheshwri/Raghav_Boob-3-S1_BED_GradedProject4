package com.gl.empmanagement.service;

import java.util.List;

import com.gl.empmanagement.entities.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theemployee);

	public void deleteById(int theId);

	public List<Employee> findAllByFirstName(String theFname);

	public List<Employee> OrderbyFirstName(String orderType);

}
