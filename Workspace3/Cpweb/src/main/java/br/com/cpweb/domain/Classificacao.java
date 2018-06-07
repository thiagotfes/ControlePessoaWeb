package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Classificacao extends GenericDomain {
	@Column(length = 6, nullable = false)
	private String cdclassificacao;
	@Column(length = 50, nullable = false)
	private String nome;

	public String getCdclassificacao() {
		return cdclassificacao;
	}

	public void setCdclassificacao(String cdclassificacao) {
		this.cdclassificacao = cdclassificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
