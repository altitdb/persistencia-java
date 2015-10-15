package br.edu.fcv.exemplo05;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "DOCUMENT_ONE", "DOCUMENT_TWO" }) })
public class Client implements Serializable {

	private static final long serialVersionUID = 23L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	private Long clientId;
	@Column
	private String name;
	@Column(name = "DOCUMENT_ONE")
	private String documentOne;
	@Column(name = "DOCUMENT_TWO")
	private String documentTwo;
	@Column(name = "DOCUMENT_THREE", unique = true)
	private String documentThree;

}
