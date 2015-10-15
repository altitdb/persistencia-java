package br.edu.fcv.exemplo06;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Dependent implements Serializable {

	private static final long serialVersionUID = 23L;
	
	@EmbeddedId
	private DependentPK dependentPK;
	@Column
	private BigDecimal price;

}
