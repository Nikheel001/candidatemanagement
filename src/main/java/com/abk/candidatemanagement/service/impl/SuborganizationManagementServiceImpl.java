package com.abk.candidatemanagement.service.impl;

import org.springframework.stereotype.Service;

import com.abk.candidatemanagement.model.Suborganization;
import com.abk.candidatemanagement.repo.SuborganizationRepo;
import com.abk.candidatemanagement.service.SuborganizationManagementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SuborganizationManagementServiceImpl implements SuborganizationManagementService {

	private final SuborganizationRepo suborganizationRepo;

	@Override
	public Suborganization createOneSuborganization(Suborganization suborganization) {
		return suborganizationRepo.save(suborganization);
	}

}
