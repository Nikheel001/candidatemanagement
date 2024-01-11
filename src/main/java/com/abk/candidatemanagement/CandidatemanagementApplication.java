package com.abk.candidatemanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CandidatemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidatemanagementApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.createTypeMap(Department.class, DepartmentDetail.class)
//        .addMapping(src -> src.getDepartment().getName(), DepartmentDetail::setDepartmentName);
		return modelMapper;
	}

}
