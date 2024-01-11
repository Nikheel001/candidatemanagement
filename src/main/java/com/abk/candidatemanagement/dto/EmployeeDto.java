package com.abk.candidatemanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	
	private Integer empId;

	@Min(value = 18)
	private Integer age;

	@Email
	private String email;

	@Pattern(regexp = "\\d{10}", message = "Invalid mobile number format")
	private String mobileno;

	private String name;
}