package com.abk.candidatemanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.dto.DepartmentDto;
import com.abk.candidatemanagement.entity.Department;
import com.abk.candidatemanagement.exception.ResourceNotFoundException;
import com.abk.candidatemanagement.repo.DepartmentRepo;
import com.abk.candidatemanagement.service.DepartmentManagementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentManagementServiceImpl implements DepartmentManagementService {

	private final ModelMapper mapper;
	private final DepartmentRepo departmentRepo;

	@Override
	public List<DepartmentDto> fetchAllDepartments() {
		return departmentRepo.findAll().stream().map((i) -> mapper.map(i, DepartmentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto creatDepartment(DepartmentDto departmentDetail) {
		Department department = mapper.map(departmentDetail, Department.class);
		return mapper.map(departmentRepo.save(department), DepartmentDto.class);
	}

	@Override
	public DepartmentDto readDepartmentById(Integer departmentId) {
		return mapper.map(departmentRepo.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department not found for id: {%d}".formatted(departmentId))),
				DepartmentDto.class);
	}

	@Override
	public DepartmentDto modifyDepartment(Integer departmentId, DepartmentDto departmentDto) {
		Department department = departmentRepo.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department not found for id: {%d}".formatted(departmentId)));
		department.setName(departmentDto.getName());
		return mapper.map(departmentRepo.saveAndFlush(department), DepartmentDto.class);
	}

	@Override
	public void removeDepartmentById(Integer departmentId) {
		departmentRepo.deleteById(departmentId);
	}

}
