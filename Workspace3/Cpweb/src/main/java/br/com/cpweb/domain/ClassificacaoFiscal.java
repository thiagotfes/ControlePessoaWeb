package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class ClassificacaoFiscal extends GenericDomain {
	
	@Column(length = 6, nullable = false, unique = true)
	private String cdclassificacaofiscal;
	
	@Column(length = 10, nullable = false)
	private String classificacao;
	
	@Column(length = 3, nullable = false)
	private String alipi;
	
	@Column(length = 9, nullable = false)
	private String cest;

	public String getCdclassificacaofiscal() {
		return cdclassificacaofiscal;
	}

	public void setCdclassificacaofiscal(String cdclassificacaofiscal) {
		this.cdclassificacaofiscal = cdclassificacaofiscal;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getAlipi() {
		return alipi;
	}

	public void setAlipi(String alipi) {
		this.alipi = alipi;
	}

	public String getCest() {
		return cest;
	}

	public void setCest(String cest) {
		this.cest = cest;
	}
	
	

}
