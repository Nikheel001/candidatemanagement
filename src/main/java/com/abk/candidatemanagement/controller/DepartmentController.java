package com.abk.candidatemanagement.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.model.Department;
import com.abk.candidatemanagement.service.DepartmentManagementService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class DepartmentController {

	private final DepartmentManagementService DepartmentManagementService;

	@PostMapping
	public Department createDepartment(@RequestBody Department Department) {
		return DepartmentManagementService.creatDepartment(Department);
	}

	@GetMapping("")
	public Department fetchDepartment(@PathVariable Integer DepartmentId) {
		return DepartmentManagementService.readDepartmentById(DepartmentId);
	}

	@PutMapping("")
	public Department modifyDepartment(@RequestBody Department Department) {
		return DepartmentManagementService.modifyDepartment(Department);
	}

	@DeleteMapping
	public void deleteDepartment(@PathVariable Integer DepartmentId) {
		DepartmentManagementService.removeDepartmentById(DepartmentId);
	}
}
