package com.abk.candidatemanagement.service;

import com.abk.candidatemanagement.model.Employee;

public interface EmployeeManagementService {

	Employee creatEmployee(Employee employee);
	Employee readEmployeeById(Integer employeeId);
	Employee modifyEmployee(Employee employee);
	void removeEmployeeById(Integer employeeId);
}
