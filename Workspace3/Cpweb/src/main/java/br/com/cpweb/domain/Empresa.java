package br.com.cpweb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Empresa extends GenericDomain {	
	@Column(length = 6, nullable = false, unique = true)
	private String cdempresa;

	@Column(length = 50, nullable = false, unique = true)
	private String nomeempresa;
	
	@Column(length = 19, nullable = false, unique = true)
	private String cpfcnpj;
	
	@Column(length = 200)
	private String endereco;
	
	@Column(length = 10)
	private String nr;
	
	@Column(length = 200)
	private String complemento;
	
	@Column(length = 15)
	private String cep;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 15)
	private String telefone;	
	
	@Column(length = 10)
	private String inscricaomunicipal;	
	
	@Column(length = 10)
	private String inscricaoestadual;	
	
	@Column(length = 15)
	private String cnae;	
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtcadastro;
	
	@Column(nullable = false)
	private Boolean ativo;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pais pais;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Bairro bairro;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Regime regime;

	public String getCdempresa() {
		return cdempresa;
	}

	public void setCdempresa(String cdempresa) {
		this.cdempresa = cdempresa;
	}

	public String getNomeempresa() {
		return nomeempresa;
	}

	public void setNomeempresa(String nomeempresa) {
		this.nomeempresa = nomeempresa;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getInscricaomunicipal() {
		return inscricaomunicipal;
	}

	public void setInscricaomunicipal(String inscricaomunicipal) {
		this.inscricaomunicipal = inscricaomunicipal;
	}

	public String getInscricaoestadual() {
		return inscricaoestadual;
	}

	public void setInscricaoestadual(String inscricaoestadual) {
		this.inscricaoestadual = inscricaoestadual;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	public Date getDtcadastro() {
		return dtcadastro;
	}

	public void setDtcadastro(Date dtcadastro) {
		this.dtcadastro = dtcadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Regime getRegime() {
		return regime;
	}

	public void setRegime(Regime regime) {
		this.regime = regime;
	}
	
	
}
