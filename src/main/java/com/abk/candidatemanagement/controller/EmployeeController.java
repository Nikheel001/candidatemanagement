package com.abk.candidatemanagement.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.dto.EmployeeDto;
import com.abk.candidatemanagement.service.EmployeeManagementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeManagementService employeeManagementService;

	@PostMapping
	public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto employee) {
		return employeeManagementService.creatEmployee(employee);
	}

	@GetMapping("{employeeId}")
	public EmployeeDto fetchEmployee(@PathVariable Integer employeeId) {
		return employeeManagementService.readEmployeeById(employeeId);
	}

	@PutMapping("{employeeId}")
	public EmployeeDto modifyEmployee(@PathVariable Integer employeeId, @Valid @RequestBody EmployeeDto employee) {
		return employeeManagementService.modifyEmployee(employeeId, employee);
	}

	@DeleteMapping("{employeeId}")
	public void deleteEmployee(@PathVariable Integer employeeId) {
		employeeManagementService.removeEmployeeById(employeeId);
	}
}
