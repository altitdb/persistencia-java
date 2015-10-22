package br.edu.fcv.aula04.exemplo04;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa {
 
	private static final long serialVersionUID = 23L;
	
	@Column
    private String cnpj;
 
}