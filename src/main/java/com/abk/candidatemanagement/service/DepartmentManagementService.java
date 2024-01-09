package com.abk.candidatemanagement.service;

import com.abk.candidatemanagement.model.Department;

public interface DepartmentManagementService {
	Department creatDepartment(Department department);
	Department readDepartmentById(Integer departmentId);
	Department modifyDepartment(Department department);
	void removeDepartmentById(Integer departmentId);
}
