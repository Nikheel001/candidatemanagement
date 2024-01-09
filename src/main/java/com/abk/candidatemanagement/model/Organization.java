package com.abk.candidatemanagement.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the organization database table.
 * 
 */
@Entity
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="org_id")
	private Integer orgId;

	private String name;

	//bi-directional many-to-one association to Suborganization
	@OneToMany(mappedBy="organization")
	private List<Suborganization> suborganizations;

	public Organization() {
	}

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Suborganization> getSuborganizations() {
		return this.suborganizations;
	}

	public void setSuborganizations(List<Suborganization> suborganizations) {
		this.suborganizations = suborganizations;
	}

	public Suborganization addSuborganization(Suborganization suborganization) {
		getSuborganizations().add(suborganization);
		suborganization.setOrganization(this);

		return suborganization;
	}

	public Suborganization removeSuborganization(Suborganization suborganization) {
		getSuborganizations().remove(suborganization);
		suborganization.setOrganization(null);

		return suborganization;
	}

}