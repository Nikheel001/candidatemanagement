package com.abk.candidatemanagement.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.dto.OrganizationDto;
import com.abk.candidatemanagement.entity.Organization;
import com.abk.candidatemanagement.repo.OrganizationRepo;
import com.abk.candidatemanagement.service.OrganizationManagementService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrganizationManagementServiceImpl implements OrganizationManagementService {

	private final OrganizationRepo organizationRepo;
	private final ModelMapper mapper;

	@Override
	public OrganizationDto createOneOrganization(OrganizationDto organizationDto) {
		Organization organization = mapper.map(organizationDto, Organization.class);
		return mapper.map(organizationRepo.save(organization), OrganizationDto.class);
	}

}
