package com.epl.service.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.employee.model.Employee;
import com.epl.service.employee.model.ResponseData;
import com.epl.service.employee.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/")
	public ResponseEntity<ResponseData<Employee>> add(@RequestBody Employee employee) {
		LOGGER.info("Employee add: {}", employee);
		Employee data = repository.add(employee);
		
		return ResponseEntity.ok(ResponseData.create("SUCCESS", "Thanh Cong", data));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseData<Employee>> findById(@PathVariable("id") Long id) {
		LOGGER.info("Employee find: id={}", id);
		Employee data = repository.findById(id);
		
		return ResponseEntity.ok(ResponseData.create("SUCCESS", "Thanh Cong", data));
	}
	
	@GetMapping("/")
	public ResponseEntity<ResponseData<List<Employee>>> findAll() {
		LOGGER.info("Employee find");
		List<Employee> data = repository.findAll();
		
		return ResponseEntity.ok(ResponseData.create("SUCCESS", "Thanh Cong", data));
	}
	
	@GetMapping("/department/{departmentId}")
	public ResponseEntity<ResponseData<List<Employee>>> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		LOGGER.info("Employee find: departmentId={}", departmentId);
		
		List<Employee> data = repository.findByDepartment(departmentId);
		
		return ResponseEntity.ok(ResponseData.create("SUCCESS", "Thanh Cong", data));
	}
	
	@GetMapping("/organization/{organizationId}")
	public ResponseEntity<ResponseData<List<Employee>>> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Employee find: organizationId={}", organizationId);
		List<Employee> data = repository.findByOrganization(organizationId);
		
		return ResponseEntity.ok(ResponseData.create("SUCCESS", "Thanh Cong", data));
	}
	
}
