package com.epl.service.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epl.service.department.client.EmployeeClient;
import com.epl.service.department.model.Employee;
import com.epl.service.department.model.EmployeeServiceException;
import com.epl.service.department.model.ResponseData;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeClient employeeClient;

	@Override
	public List<Employee> findByDepartment(Long departmentId) {
		ResponseData<List<Employee>> response = employeeClient.findByDepartment(departmentId);
		if(response != null && !response.getCode().equals("SUCCESS")) {
			throw new EmployeeServiceException(response.getCode(), response.getMessage());
		}
		
		return response.getData();
	}
	
	
}
