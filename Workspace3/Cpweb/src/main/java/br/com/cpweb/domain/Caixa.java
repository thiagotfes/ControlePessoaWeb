package br.com.cpweb.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Caixa extends GenericDomain {
	
	@Column(nullable = false, unique = true)
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date dataFechamento;
	
	
	@Column(nullable = false, precision = 15, scale = 2)
	private BigDecimal valorAbertura;


	public BigDecimal getValorAbertura() {
		return valorAbertura;
	}


	public void setValorAbertura(BigDecimal valorAbertura) {
		this.valorAbertura = valorAbertura;
	}


	public Date getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public Date getDataFechamento() {
		return dataFechamento;
	}


	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	
	
}
