package br.edu.fcv.exemplo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "NamedQueryCity", query = "SELECT c FROM City c"),
		@NamedQuery(name = "NamedQueryCityWithRestriction", query = "SELECT c FROM City c WHERE c.name = :NAME"),
		@NamedQuery(name = "NamedQueryCityJoin", query = "SELECT c FROM City c JOIN c.state e")})
public class City implements Serializable {

	private static final long serialVersionUID = 23L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITY_ID")
	private Long cityId;
	@Column
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "STATE_ID")
	private State state;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
