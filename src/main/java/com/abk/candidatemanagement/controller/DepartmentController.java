package com.abk.candidatemanagement.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.model.Department;
import com.abk.candidatemanagement.service.DepartmentManagementService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/department/")
public class DepartmentController {

	private final DepartmentManagementService DepartmentManagementService;

	@PostMapping
	public Department createDepartment(@RequestBody Department department) {
		return DepartmentManagementService.creatDepartment(department);
	}

	@GetMapping("{departmentId}")
	public Department fetchDepartment(@PathVariable Integer departmentId) {
		return DepartmentManagementService.readDepartmentById(departmentId);
	}

	@PutMapping
	public Department modifyDepartment(@RequestBody Department department) {
		return DepartmentManagementService.modifyDepartment(department);
	}

	@DeleteMapping("{departmentId}")
	public void deleteDepartment(@PathVariable Integer departmentId) {
		DepartmentManagementService.removeDepartmentById(departmentId);
	}
}
