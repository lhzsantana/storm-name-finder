package org.ecjfh.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Filial extends Empresa {

	@ManyToOne(fetch = FetchType.EAGER)
	private Matriz matriz;

	public Matriz getMatriz() {
		return matriz;
	}

	public void setMatriz(Matriz matriz) {
		this.matriz = matriz;
	}
}
