package com.epl.service.department.controller;

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

import com.epl.service.department.model.Department;
import com.epl.service.department.model.ResponseData;
import com.epl.service.department.repository.DepartmentRepository;

@RestController
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentRepository repository;
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/")
	public ResponseEntity<ResponseData<Department>> add(@RequestBody Department department) {
		LOGGER.info("Department add: {}", department);
		
		Department data = repository.add(department);
		return ResponseEntity.ok(ResponseData.create(ResponseData.SUCCESS, "SUCCESS", data));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseData<Department>> findById(@PathVariable("id") Long id) {
		LOGGER.info("Department find: id={}", id);
		Department data = repository.findById(id);
		
		return ResponseEntity.ok(ResponseData.create(ResponseData.SUCCESS, "SUCCESS", data));
	}
	
	@GetMapping("/")
	public ResponseEntity<ResponseData<List<Department>>>  findAll() {
		LOGGER.info("Department find");
		
		List<Department> data = repository.findAll();
		return ResponseEntity.ok(ResponseData.create(ResponseData.SUCCESS, "SUCCESS", data)); 
	}
	
	@GetMapping("/organization/{organizationId}")
	public ResponseEntity<ResponseData<List<Department>>> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		List<Department> data = repository.findByOrganization(organizationId);
		
		return ResponseEntity.ok(ResponseData.create(ResponseData.SUCCESS, "SUCCESS", data)); 
	}
	
	@GetMapping("/organization/{organizationId}/with-employees")
	public ResponseEntity<ResponseData<List<Department>>> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		List<Department> departments = repository.findByOrganization(organizationId);
		departments.forEach(d -> d.setEmployees(employeeService.findByDepartment(d.getId())));
		return ResponseEntity.ok(ResponseData.create(ResponseData.SUCCESS, "SUCCESS", departments));
	}
	
}
