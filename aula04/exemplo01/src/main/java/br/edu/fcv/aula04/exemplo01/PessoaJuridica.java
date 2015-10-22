package br.edu.fcv.aula04.exemplo01;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "J")
public class PessoaJuridica extends Pessoa {
 
	private static final long serialVersionUID = 23L;
	
	@Column
    private String cnpj;
 
}