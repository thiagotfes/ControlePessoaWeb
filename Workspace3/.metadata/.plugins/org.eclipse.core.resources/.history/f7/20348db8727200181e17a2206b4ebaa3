package br.com.cpweb.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain {	
	@Column(length = 6, nullable = false, unique = true)
	private String cdproduto;

	@Column(length = 250, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Short quantidade;
	
	@Column(nullable = false, precision = 15, scale = 2)
	private BigDecimal preco;
	
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal pesobruto;
	
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal pesoliquido;
	
	@Column(nullable = false)
	private Character origem;
	
	@Column(length = 300)
	private String observacao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtcadastro;
	
	@Column(nullable = false)
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Fabricante fabricante;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Icms icms;

	@ManyToOne
	@JoinColumn(nullable = false)
	private ClassificacaoFiscal classificacaofiscal;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoa fornecedor;

	@ManyToOne
	@JoinColumn(nullable = false)
	private GrupoProduto grupoproduto;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Unidade unidade;

	@ManyToOne
	@JoinColumn(nullable = false)
	private TipoProduto tipoproduto;

	public String getCdproduto() {
		return cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getPesobruto() {
		return pesobruto;
	}

	public void setPesobruto(BigDecimal pesobruto) {
		this.pesobruto = pesobruto;
	}

	public BigDecimal getPesoliquido() {
		return pesoliquido;
	}

	public void setPesoliquido(BigDecimal pesoliquido) {
		this.pesoliquido = pesoliquido;
	}

	public Character getOrigem() {
		return origem;
	}

	public void setOrigem(Character origem) {
		this.origem = origem;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Icms getIcms() {
		return icms;
	}

	public void setIcms(Icms icms) {
		this.icms = icms;
	}

	public ClassificacaoFiscal getClassificacaofiscal() {
		return classificacaofiscal;
	}

	public void setClassificacaofiscal(ClassificacaoFiscal classificacaofiscal) {
		this.classificacaofiscal = classificacaofiscal;
	}

	public Pessoa getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Pessoa fornecedor) {
		this.fornecedor = fornecedor;
	}

	public GrupoProduto getGrupoproduto() {
		return grupoproduto;
	}

	public void setGrupoproduto(GrupoProduto grupoproduto) {
		this.grupoproduto = grupoproduto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public TipoProduto getTipoproduto() {
		return tipoproduto;
	}

	public void setTipoproduto(TipoProduto tipoproduto) {
		this.tipoproduto = tipoproduto;
	}
	
}
