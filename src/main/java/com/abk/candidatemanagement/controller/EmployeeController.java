package com.abk.candidatemanagement.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.model.Employee;
import com.abk.candidatemanagement.service.EmployeeManagementService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

	private final EmployeeManagementService employeeManagementService;

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeManagementService.creatEmployee(employee);
	}

	@GetMapping("")
	public Employee fetchEmployee(@PathVariable Integer employeeId) {
		return employeeManagementService.readEmployeeById(employeeId);
	}

	@PutMapping("")
	public Employee modifyEmployee(@RequestBody Employee employee) {
		return employeeManagementService.modifyEmployee(employee);
	}

	@DeleteMapping
	public void deleteEmployee(@PathVariable Integer employeeId) {
		employeeManagementService.removeEmployeeById(employeeId);
	}
}
