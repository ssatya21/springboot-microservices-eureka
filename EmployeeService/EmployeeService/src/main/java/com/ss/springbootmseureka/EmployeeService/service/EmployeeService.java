package com.ss.springbootmseureka.EmployeeService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ss.springbootmseureka.EmployeeService.entity.Employee;
import com.ss.springbootmseureka.EmployeeService.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepo repo;
	
	public ResponseEntity<List<Employee>> getEmployeeByDeptId(Integer deptId) {
		List<Employee> employees = repo.findByDepartmentId(deptId);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee employeeAdded = repo.save(employee);
		return new ResponseEntity<Employee>(employeeAdded, HttpStatus.OK);
	}

}
