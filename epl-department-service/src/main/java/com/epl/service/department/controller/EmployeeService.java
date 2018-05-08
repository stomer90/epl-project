package com.epl.service.department.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.epl.service.department.model.Employee;

public interface EmployeeService {
	List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
}
