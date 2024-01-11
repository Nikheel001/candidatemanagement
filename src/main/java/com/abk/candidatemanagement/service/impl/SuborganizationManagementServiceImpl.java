package com.abk.candidatemanagement.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.dto.SuborganizationDto;
import com.abk.candidatemanagement.entity.Suborganization;
import com.abk.candidatemanagement.repo.SuborganizationRepo;
import com.abk.candidatemanagement.service.SuborganizationManagementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SuborganizationManagementServiceImpl implements SuborganizationManagementService {

	private final SuborganizationRepo suborganizationRepo;
	private final ModelMapper mapper;

	@Override
	public SuborganizationDto createOneSuborganization(SuborganizationDto suborganizationDto) {
		Suborganization suborganization = mapper.map(suborganizationDto, Suborganization.class);
		return mapper.map(suborganizationRepo.save(suborganization), SuborganizationDto.class);
	}

}
