package com.abk.candidatemanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

	@NotNull
	@Min(value = 18)
	private Integer age;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Pattern(regexp = "\\d{10}", message = "Invalid mobile number format")
	private String mobileno;

	@NotBlank
	private String name;
}