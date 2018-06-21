package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.HistoricoDAO;
import br.com.cpweb.DAO.ProdutoDAO;
import br.com.cpweb.domain.Historico;
import br.com.cpweb.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class HistoricoBean implements Serializable {
	private Produto produto;
	private Boolean exibirPainelDeDados;
	private Historico historico;

	
	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public Boolean getExibirPainelDeDados() {
		return exibirPainelDeDados;
	}

	public void setExibirPainelDeDados(Boolean exibirPainelDeDados) {
		this.exibirPainelDeDados = exibirPainelDeDados;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@PostConstruct
	public void novo(){
		historico = new Historico();
		produto = new Produto();
		exibirPainelDeDados = false;
	}
	

	
	public void buscarCodigo(){
		try {
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto resultado = produtoDAO.buscar(produto.getCodigo());
			
			if(resultado == null){
				exibirPainelDeDados = false;
				Messages.addFlashGlobalWarn("Não existe produto cadastrado para o código informado");
			} else {
				produto = resultado;
				exibirPainelDeDados = true;
			}
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar localizar o produto");
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
try {
			historico.setHorario(new Date());
			historico.setProduto(produto);
			
			HistoricoDAO historicoDAO = new HistoricoDAO();
			historicoDAO.salvar(historico);

			Messages.addFlashGlobalInfo("Histórico salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar o histórico");
			erro.printStackTrace();
		}
	}
	
}
