package com.abk.candidatemanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.dto.SuborganizationDto;
import com.abk.candidatemanagement.service.SuborganizationManagementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/suborganization")
public class SuborganizationController {

	private final SuborganizationManagementService suborganizationManagementService;

	@PostMapping
	public SuborganizationDto createOrganization(@Valid @RequestBody SuborganizationDto suborganization) {
		return suborganizationManagementService.createOneSuborganization(suborganization);
	}
}
