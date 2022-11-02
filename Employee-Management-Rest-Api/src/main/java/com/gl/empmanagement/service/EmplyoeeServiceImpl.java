package com.gl.empmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.gl.empmanagement.entities.Employee;
import com.gl.empmanagement.repository.EmplyoeeRepository;

@Repository
public class EmplyoeeServiceImpl implements EmployeeService {

	@Autowired
	private EmplyoeeRepository emplyoeeRepository;

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = emplyoeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee employee = new Employee();

		employee = emplyoeeRepository.findById(theId).get();
		return employee;
	}

	@Transactional
	public void save(Employee theemployee) {
		emplyoeeRepository.save(theemployee);

	}

	@Transactional
	public void deleteById(int theId) {
		emplyoeeRepository.deleteById(theId);
	}

	@Override
	public List<Employee> findAllByFirstName(String theFname) {

		List<Employee> employees = emplyoeeRepository.findByfirstname(theFname);
		return employees;
	}

	@Override
	public List<Employee> OrderbyFirstName(String orderType) {
		if (orderType.equals("asc")) {
			List<Employee> employees = emplyoeeRepository.findAll(Sort.by("firstname").ascending());
			return employees;
		} else if (orderType.equals("desc")) {
			List<Employee> employees = emplyoeeRepository.findAll(Sort.by("firstname").descending());
			return employees;
		} else {
			return null;
		}

	}

}
