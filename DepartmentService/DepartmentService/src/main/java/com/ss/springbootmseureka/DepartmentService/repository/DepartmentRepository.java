package com.ss.springbootmseureka.DepartmentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.springbootmseureka.DepartmentService.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
