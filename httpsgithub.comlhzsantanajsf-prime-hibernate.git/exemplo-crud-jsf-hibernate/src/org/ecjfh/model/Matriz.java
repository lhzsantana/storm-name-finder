package org.ecjfh.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Matriz extends Empresa {
	
    @OneToMany(fetch=FetchType.EAGER,mappedBy="matriz", orphanRemoval=true)
	private Set<Filial> filiais;

	public Set<Filial> getFiliais() {
		return filiais;
	}

	public void setFiliais(Set<Filial> filiais) {
		this.filiais = filiais;
	}
	
}
