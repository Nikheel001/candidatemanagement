package com.abk.candidatemanagement.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.model.Employee;
import com.abk.candidatemanagement.service.EmployeeManagementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee/")
@Validated
public class EmployeeController {

	private final EmployeeManagementService employeeManagementService;

	@PostMapping
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeManagementService.creatEmployee(employee);
	}

	@GetMapping("{employeeId}")
	public Employee fetchEmployee(@PathVariable Integer employeeId) {
		return employeeManagementService.readEmployeeById(employeeId);
	}

	@PutMapping
	public Employee modifyEmployee(@Valid @RequestBody Employee employee) {
		return employeeManagementService.modifyEmployee(employee);
	}

	@DeleteMapping("{employeeId}")
	public void deleteEmployee(@PathVariable Integer employeeId) {
		employeeManagementService.removeEmployeeById(employeeId);
	}
	
	@PatchMapping("department/{departmentId}")
	public Employee belongsToDepartment(@Valid @RequestBody Employee employee, @PathVariable Integer departmentId) {
		return employeeManagementService.addEmployeeToDepartment(employee, departmentId);
	}
	
	@PatchMapping("role/{roleId}")
	public Employee attachRoleToEmployee(@Valid @RequestBody Employee employee, @PathVariable Integer roleId) {
		return employeeManagementService.attachRoleToEmployee(employee, roleId);
	}
}
