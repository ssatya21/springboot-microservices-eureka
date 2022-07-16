package com.ss.springbootmseureka.EmployeeService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.springbootmseureka.EmployeeService.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByDepartmentId(Integer id);

}
