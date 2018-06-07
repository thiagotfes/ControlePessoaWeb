package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain {
	@Column(length = 6, nullable = false, unique = true)
	private String cduf;
	@Column(length = 2, nullable = false, unique = true)
	private String nome;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pais pais;

	public String getCduf() {
		return cduf;
	}

	public void setCduf(String cduf) {
		this.cduf = cduf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
