package br.com.cpweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class TipoUsuario extends GenericDomain {
	@Column(length = 6, nullable = false, unique=true)
	private String cdtipousuario;
	@Column(length = 15, nullable = false, unique=true)
	private String nome;

	public String getCdtipousuario() {
		return cdtipousuario;
	}

	public void setCdtipousuario(String cdtipousuario) {
		this.cdtipousuario = cdtipousuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}