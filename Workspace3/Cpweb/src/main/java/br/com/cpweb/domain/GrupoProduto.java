package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class GrupoProduto extends GenericDomain {
	
	@Column(length = 6, nullable = false, unique = true)
	private String cdgrupoproduto;
	
	@Column(length = 50, nullable = false)
	private String descricao;

	public String getCdgrupoproduto() {
		return cdgrupoproduto;
	}

	public void setCdgrupoproduto(String cdgrupoproduto) {
		this.cdgrupoproduto = cdgrupoproduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	

}
