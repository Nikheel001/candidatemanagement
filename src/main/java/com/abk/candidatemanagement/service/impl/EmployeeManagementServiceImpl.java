package com.abk.candidatemanagement.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.dto.EmployeeDto;
import com.abk.candidatemanagement.entity.Employee;
import com.abk.candidatemanagement.exception.ResourceNotFoundException;
import com.abk.candidatemanagement.repo.EmployeeRepo;
import com.abk.candidatemanagement.service.EmployeeManagementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	private final EmployeeRepo employeeRepo;
	private final ModelMapper mapper;

	@Override
	public EmployeeDto creatEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.map(employeeDto, Employee.class);
		return mapper.map(employeeRepo.save(employee), EmployeeDto.class);
	}

	@Override
	public EmployeeDto readEmployeeById(Integer employeeId) {
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee not found for id: {%d}".formatted(employeeId)));
		return mapper.map(employee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto modifyEmployee(Integer employeeId, EmployeeDto employeeDto) {
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee not found for id: {%d}".formatted(employeeId)));

		employee.setName(employeeDto.getName());
		employee.setAge(employeeDto.getAge());
		employee.setEmail(employeeDto.getEmail());
		employee.setMobileno(employeeDto.getMobileno());

		return mapper.map(employeeRepo.saveAndFlush(employee), EmployeeDto.class);
	}

	@Override
	public void removeEmployeeById(Integer employeeId) {
		employeeRepo.deleteById(employeeId);
	}

}
