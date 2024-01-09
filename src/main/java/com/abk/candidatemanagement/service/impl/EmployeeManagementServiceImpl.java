package com.abk.candidatemanagement.service.impl;

import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.model.Employee;
import com.abk.candidatemanagement.repo.EmployeeRepo;
import com.abk.candidatemanagement.service.EmployeeManagementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	private final EmployeeRepo EmployeeRepo;

	@Override
	public Employee creatEmployee(Employee employee) {
		return EmployeeRepo.save(employee);
	}

	@Override
	public Employee readEmployeeById(Integer employeeId) {
		return EmployeeRepo.findById(employeeId).orElseThrow();
	}

	@Override
	public Employee modifyEmployee(Employee employee) {
		return EmployeeRepo.saveAndFlush(employee);
	}

	@Override
	public void removeEmployeeById(Integer employeeId) {
		EmployeeRepo.deleteById(employeeId);
	}

}
