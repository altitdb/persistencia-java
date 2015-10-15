package br.edu.fcv.exemplo06;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registry implements Serializable {

	private static final long serialVersionUID = 23L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REGISTRY_ID")
	private Long registryId;
	@ManyToOne
	private Dependent dependent;
}
