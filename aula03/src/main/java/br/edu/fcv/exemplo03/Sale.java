package br.edu.fcv.exemplo03;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sale implements Serializable {

	private static final long serialVersionUID = 23L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SALE_ID")
	private Long saleId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date date;
	@OneToMany(fetch = FetchType.LAZY, 
			   cascade = CascadeType.ALL, 
			   mappedBy = "sale", 
			   targetEntity = Item.class)
	private List<Item> itens;
}
