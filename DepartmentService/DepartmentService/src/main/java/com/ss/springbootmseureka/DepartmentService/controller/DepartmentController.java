package com.ss.springbootmseureka.DepartmentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ss.springbootmseureka.DepartmentService.entity.Department;
import com.ss.springbootmseureka.DepartmentService.entity.EmpDepartment;
import com.ss.springbootmseureka.DepartmentService.entity.Employee;
import com.ss.springbootmseureka.DepartmentService.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	public DepartmentService service;
	
	@RequestMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("This is from Dept Service", HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		return service.addDepartment(department);
	}
	
	@GetMapping("/id/{deptId}")
	public ResponseEntity<EmpDepartment> getAllEmployeesOfDept(@PathVariable Integer deptId) {
		EmpDepartment listEmpOfDept = new EmpDepartment();
		Department department = service.getDepartment(deptId);
		listEmpOfDept.setDepartment(department);
		
		
		//List<Employee> employees = restTemplate.getForObject("http://localhost:8081/employee/id/"+deptId, List.class);
		List<Employee> employees = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/id/"+deptId, List.class);
		listEmpOfDept.setEmployees(employees);
		
		return new ResponseEntity<EmpDepartment>(listEmpOfDept, HttpStatus.OK);
		
	}
}
