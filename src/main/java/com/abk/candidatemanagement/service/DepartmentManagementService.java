package com.abk.candidatemanagement.service;

import java.util.List;

import com.abk.candidatemanagement.dto.DepartmentDto;

public interface DepartmentManagementService {
	
	List<DepartmentDto> fetchAllDepartments();
	
	DepartmentDto creatDepartment(DepartmentDto department);

	DepartmentDto readDepartmentById(Integer departmentId);

	DepartmentDto modifyDepartment(Integer departmentId, DepartmentDto department);

	void removeDepartmentById(Integer departmentId);
}
