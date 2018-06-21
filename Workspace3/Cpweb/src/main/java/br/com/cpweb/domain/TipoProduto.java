package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class TipoProduto extends GenericDomain {

	@Column(length = 6, nullable = false, unique = true)
	private String cdtipoproduto;

	@Column(length = 50, nullable = false)
	private String descricaotipoproduto;

	public String getCdtipoproduto() {
		return cdtipoproduto;
	}

	public void setCdtipoproduto(String cdtipoproduto) {
		this.cdtipoproduto = cdtipoproduto;
	}

	public String getDescricaotipoproduto() {
		return descricaotipoproduto;
	}

	public void setDescricaotipoproduto(String descricaotipoproduto) {
		this.descricaotipoproduto = descricaotipoproduto;
	}

	
}