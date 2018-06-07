package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class TipoPessoa extends GenericDomain {
	@Column(length = 6, nullable = false)
	private String cdtipopessoa;
	@Column(length = 15, nullable = false)
	private String nome;

	public String getCdtipopessoa() {
		return cdtipopessoa;
	}

	public void setCdtipopessoa(String cdtipopessoa) {
		this.cdtipopessoa = cdtipopessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}