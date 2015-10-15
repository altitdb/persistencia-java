package br.edu.fcv.exemplo04;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 23L;
	@Id
	@Column(name = "PROJECT_ID")
	private Long projectId;
	@Column
	private String description;
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;
	
}