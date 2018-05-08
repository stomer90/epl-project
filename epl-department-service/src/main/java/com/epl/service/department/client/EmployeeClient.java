package com.epl.service.department.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.epl.service.department.model.Employee;
import com.epl.service.department.model.ResponseData;

@FeignClient(name = "epl-employee-service")
public interface EmployeeClient {

	@GetMapping("/department/{departmentId}")
	ResponseData<List<Employee>> findByDepartment(@PathVariable("departmentId") Long departmentId);
	
}
