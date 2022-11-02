package com.gl.empmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gl.empmanagement.entities.Employee;

public interface EmplyoeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByfirstname(String firstname);

}
