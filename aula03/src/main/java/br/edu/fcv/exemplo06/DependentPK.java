package br.edu.fcv.exemplo06;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DependentPK implements Serializable {

	private static final long serialVersionUID = 23L;

	@Column(name = "PERSON_ID")
	private Long personId;
	@Column(name = "DEPENDENT_ID")
	private Long dependentId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dependentId == null) ? 0 : dependentId.hashCode());
		result = prime * result
				+ ((personId == null) ? 0 : personId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DependentPK other = (DependentPK) obj;
		if (dependentId == null) {
			if (other.dependentId != null)
				return false;
		} else if (!dependentId.equals(other.dependentId))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		return true;
	}

}
