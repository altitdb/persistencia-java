package br.edu.fcv.aula04.exemplo03;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {
 
	private static final long serialVersionUID = 23L;
	
    @Id
    @Column(name = "ID_PESSOA")
    private Long idPessoa;
    @Column
    private String nome;
 
}