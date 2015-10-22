package br.edu.fcv.aula04.exemplo04;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class Pessoa implements Serializable {
 
	private static final long serialVersionUID = 23L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PESSOA")
    private Long idPessoa;
    @Column
    private String nome;
    @Version
    @Column
    private Timestamp versao;
 
}