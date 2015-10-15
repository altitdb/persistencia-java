package br.edu.fcv.exemplo04;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 23L;
	
	@Id
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;
	@Column
	private String name;
	@ManyToMany
	@JoinTable(name = "EMPLOYEE_PROJECT", 
		joinColumns = {
			@JoinColumn(name = "EMPLOYEE_ID", 
					    referencedColumnName = "EMPLOYEE_ID")}, 
		inverseJoinColumns = {
			@JoinColumn(name = "PROJECT_ID", 
					    referencedColumnName = "PROJECT_ID")})
	private List<Project> projects;

}