package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Unidade extends GenericDomain {

	@Column(length = 6, nullable = false, unique = true)
	private String cdunidade;

	@Column(length = 50, nullable = false)
	private String descricaounidade;

	public String getCdunidade() {
		return cdunidade;
	}

	public void setCdunidade(String cdunidade) {
		this.cdunidade = cdunidade;
	}

	public String getDescricaounidade() {
		return descricaounidade;
	}

	public void setDescricaounidade(String descricaounidade) {
		this.descricaounidade = descricaounidade;
	}

}
