package com.abk.candidatemanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.dto.DepartmentDto;
import com.abk.candidatemanagement.service.DepartmentManagementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {

	private final DepartmentManagementService DepartmentManagementService;

	@GetMapping
	public List<DepartmentDto> fetchAllDepartments() {
		return DepartmentManagementService.fetchAllDepartments();
	}

	@PostMapping
	public DepartmentDto createDepartment(@Valid @RequestBody DepartmentDto department) {
		return DepartmentManagementService.creatDepartment(department);
	}

	@GetMapping("{departmentId}")
	public DepartmentDto fetchDepartment(@PathVariable Integer departmentId) {
		return DepartmentManagementService.readDepartmentById(departmentId);
	}

	@PutMapping("{departmentId}")
	public DepartmentDto modifyDepartment(@PathVariable Integer departmentId,@Valid @RequestBody DepartmentDto department) {
		return DepartmentManagementService.modifyDepartment(departmentId, department);
	}

	@DeleteMapping("{departmentId}")
	public void deleteDepartment(@PathVariable Integer departmentId) {
		DepartmentManagementService.removeDepartmentById(departmentId);
	}
}
