package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Regime extends GenericDomain {
	@Column(length=6, nullable=false, unique=true)
	private String cdregime;
	@Column(length=50, nullable=false, unique=true)
	private String descricao;
	
	
	public String getCdregime() {
		return cdregime;
	}
	public void setCdregime(String cdregime) {
		this.cdregime = cdregime;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



}
