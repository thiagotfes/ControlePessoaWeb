package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Fabricante extends GenericDomain {
	
	@Column(length = 6, nullable = false, unique = true)
	private String cdfabricante;
	
	@Column(length = 50, nullable = false)
	private String nome;

	public String getCdfabricante() {
		return cdfabricante;
	}

	public void setCdfabricante(String cdfabricante) {
		this.cdfabricante = cdfabricante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	

}
