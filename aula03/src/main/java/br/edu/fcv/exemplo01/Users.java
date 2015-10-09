package br.edu.fcv.exemplo01;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Users implements Serializable {

	private static final long serialVersionUID = 23L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long userId;
	@Column
	private String username;
	@Column
	private String password;
	@OneToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;
}
