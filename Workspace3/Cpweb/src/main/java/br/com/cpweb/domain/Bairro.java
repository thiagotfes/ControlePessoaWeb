package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Bairro extends GenericDomain {
	@Column(length = 6, nullable = false, unique = true)
	private String cdbairro;
	@Column(length = 50, nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado uf;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pais pais;

	public String getCdbairro() {
		return cdbairro;
	}

	public void setCdbairro(String cdbairro) {
		this.cdbairro = cdbairro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getUf() {
		return uf;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
