package com.abk.candidatemanagement.service.impl;

import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.model.Department;
import com.abk.candidatemanagement.repo.DepartmentRepo;
import com.abk.candidatemanagement.service.DepartmentManagementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentManagementServiceImpl implements DepartmentManagementService {

	private final DepartmentRepo DepartmentRepo;

	@Override
	public Department creatDepartment(Department department) {
		return DepartmentRepo.save(department);
	}

	@Override
	public Department readDepartmentById(Integer departmentId) {
		return DepartmentRepo.findById(departmentId).orElseThrow();
	}

	@Override
	public Department modifyDepartment(Department department) {
		return DepartmentRepo.saveAndFlush(department);
	}

	@Override
	public void removeDepartmentById(Integer departmentId) {
		DepartmentRepo.deleteById(departmentId);
	}

}
