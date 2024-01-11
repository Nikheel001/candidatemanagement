package com.abk.candidatemanagement.service;

import com.abk.candidatemanagement.dto.EmployeeDto;

public interface EmployeeManagementService {

	EmployeeDto creatEmployee(EmployeeDto employee);

	EmployeeDto readEmployeeById(Integer employeeId);

	EmployeeDto modifyEmployee(Integer employeeId, EmployeeDto employee);

	void removeEmployeeById(Integer employeeId);
}
