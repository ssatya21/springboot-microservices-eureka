package com.ss.springbootmseureka.EmployeeService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.springbootmseureka.EmployeeService.entity.Employee;
import com.ss.springbootmseureka.EmployeeService.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	public EmployeeService service;
	
	@RequestMapping("/test")
	public ResponseEntity<String> test() {
		ResponseEntity<String> response = new ResponseEntity<String>("hello", HttpStatus.OK);
		return response;
	}
	
	@GetMapping(path="/id/{deptId}")
	public ResponseEntity<List<Employee>> getEmployeeByDeptId(@PathVariable Integer deptId) {
		return service.getEmployeeByDeptId(deptId);
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
}
