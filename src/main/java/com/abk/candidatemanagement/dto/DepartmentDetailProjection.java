package com.abk.candidatemanagement.dto;

import java.util.List;

/**
 * 
 */
public interface DepartmentDetailProjection {

	Integer getDepId();

	String getName();

	List<EmployeeDto> getEmployees();

}