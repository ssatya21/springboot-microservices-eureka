package com.ss.springbootmseureka.DepartmentService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ss.springbootmseureka.DepartmentService.entity.Department;
import com.ss.springbootmseureka.DepartmentService.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	public DepartmentRepository repo;

	public ResponseEntity<Department> addDepartment(Department department) {
		Department newDepartment = repo.save(department);
		return new ResponseEntity<Department>(newDepartment, HttpStatus.OK);
	}
	
	public Department getDepartment(Integer id) {
		Department department = repo.findById(id).get();
		return department;
	}
}
