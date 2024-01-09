package com.abk.candidatemanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abk.candidatemanagement.model.Suborganization;
import com.abk.candidatemanagement.service.SuborganizationManagementService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/suborganization/")
public class SuborganizationController {

	private final SuborganizationManagementService suborganizationManagementService;

	@PostMapping
	public Suborganization createOrganization(@RequestBody Suborganization suborganization) {
		return suborganizationManagementService.createOneSuborganization(suborganization);
	}
}
