package br.edu.fcv.aula04.exemplo03;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa {
 
	private static final long serialVersionUID = 23L;
	
	@Column
    private String cpf;
 
}