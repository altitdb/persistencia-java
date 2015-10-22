package br.edu.fcv.aula04.exemplo01;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "F")
public class PessoaFisica extends Pessoa {
 
	private static final long serialVersionUID = 23L;
	
	@Column
	private String cpf;
 
}