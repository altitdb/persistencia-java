package br.edu.fcv.aula04.exemplo02;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ID_PESSOA")
@DiscriminatorValue(value = "J")
public class PessoaJuridica extends Pessoa {
 
	private static final long serialVersionUID = 23L;
	
	@Column
    private String cnpj;
 
}