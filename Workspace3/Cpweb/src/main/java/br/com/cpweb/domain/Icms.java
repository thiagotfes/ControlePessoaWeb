package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Icms extends GenericDomain {
	
	@Column(length = 6, nullable = false, unique = true)
	private String cdicms;
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	@Column(length = 3, nullable = false)
	private String alicms;
	
	@Column(length = 3,nullable = false)
	private String sittributaria;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado uforigem;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado ufdestino;

	public String getCdicms() {
		return cdicms;
	}

	public void setCdicms(String cdicms) {
		this.cdicms = cdicms;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAlicms() {
		return alicms;
	}

	public void setAlicms(String alicms) {
		this.alicms = alicms;
	}

	public String getSittributaria() {
		return sittributaria;
	}

	public void setSittributaria(String sittributaria) {
		this.sittributaria = sittributaria;
	}

	public Estado getUforigem() {
		return uforigem;
	}

	public void setUforigem(Estado uforigem) {
		this.uforigem = uforigem;
	}

	public Estado getUfdestino() {
		return ufdestino;
	}

	public void setUfdestino(Estado ufdestino) {
		this.ufdestino = ufdestino;
	}


	
}
