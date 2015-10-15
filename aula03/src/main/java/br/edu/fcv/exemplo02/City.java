package br.edu.fcv.exemplo02;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City implements Serializable {

	private static final long serialVersionUID = 23L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITY_ID")
	private Long cityId;
	@Column
	private String name;
	@ManyToOne
	@JoinColumn(name = "STATE_ID")
	private State state;

}
