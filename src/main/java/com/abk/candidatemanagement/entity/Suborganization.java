package com.abk.candidatemanagement.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the suborganization database table.
 * 
 */
@Entity
@NamedQuery(name="Suborganization.findAll", query="SELECT s FROM Suborganization s")
public class Suborganization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sub_org_id")
	private Integer subOrgId;

	private String name;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="suborganization")
	private List<Employee> employees;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="part_of")
	private Organization organization;

	public Suborganization() {
	}

	public Integer getSubOrgId() {
		return this.subOrgId;
	}

	public void setSubOrgId(Integer subOrgId) {
		this.subOrgId = subOrgId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setSuborganization(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setSuborganization(null);

		return employee;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}