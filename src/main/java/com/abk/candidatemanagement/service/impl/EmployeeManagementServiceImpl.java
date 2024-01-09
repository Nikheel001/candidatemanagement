package com.abk.candidatemanagement.service.impl;

import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.model.Department;
import com.abk.candidatemanagement.model.Role;
import com.abk.candidatemanagement.model.Employee;
import com.abk.candidatemanagement.repo.DepartmentRepo;
import com.abk.candidatemanagement.repo.EmployeeRepo;
import com.abk.candidatemanagement.repo.RoleRepo;
import com.abk.candidatemanagement.service.EmployeeManagementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	private final EmployeeRepo employeeRepo;
	private final DepartmentRepo departmentRepo;
	private final RoleRepo roleRepo;

	@Override
	public Employee creatEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee readEmployeeById(Integer employeeId) {
		return employeeRepo.findById(employeeId).orElseThrow();
	}

	@Override
	public Employee modifyEmployee(Employee employee) {
		return employeeRepo.saveAndFlush(employee);
	}

	@Override
	public void removeEmployeeById(Integer employeeId) {
		employeeRepo.deleteById(employeeId);
	}

	@Override
	public Employee addEmployeeToDepartment(Employee employee, Integer departmentId) {
		Department department = departmentRepo.findById(departmentId).orElseThrow();
		employee.setDepartment(department);
		return employeeRepo.saveAndFlush(employee);
	}

	@Override
	public Employee attachRoleToEmployee(Employee employee, Integer roleId) {
		Role role = roleRepo.findById(roleId).orElseThrow();
		employee.setRole(role);
		return employeeRepo.saveAndFlush(employee);
	}

}
