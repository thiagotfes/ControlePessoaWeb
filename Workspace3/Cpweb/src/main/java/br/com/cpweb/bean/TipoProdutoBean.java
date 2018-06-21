package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.TipoProdutoDAO;
import br.com.cpweb.domain.TipoProduto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TipoProdutoBean implements Serializable {
	private TipoProduto tipoproduto;
	private List<TipoProduto> tiposprodutos;


	public TipoProduto getTipoproduto() {
		return tipoproduto;
	}

	public void setTipoproduto(TipoProduto tipoproduto) {
		this.tipoproduto = tipoproduto;
	}

	public List<TipoProduto> getTiposprodutos() {
		return tiposprodutos;
	}

	public void setTiposprodutos(List<TipoProduto> tiposprodutos) {
		this.tiposprodutos = tiposprodutos;
	}

	// Métodos liscar, buscar, gravar, editar e excluir
	@PostConstruct
	public void listar() {
		try {
			TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
			tiposprodutos = tipoProdutoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os tipos de produtos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		tipoproduto = new TipoProduto();
	}

	public void salvar() {
		try {
			TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
			tipoProdutoDAO.merge(tipoproduto);
			novo();
			Messages.addGlobalInfo("Tipo de produto salvo com sucesso");
			tiposprodutos = tipoProdutoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o tipo de produto");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			tipoproduto = (TipoProduto) evento.getComponent().getAttributes()
					.get("tipoprodutoSelecionado");

			TipoProdutoDAO tipoProdutoDAO = new TipoProdutoDAO();
			tipoProdutoDAO.excluir(tipoproduto);
			tiposprodutos = tipoProdutoDAO.listar();

			Messages.addGlobalInfo("Tipo de produto removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o tipo de produto");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		tipoproduto = (TipoProduto) evento.getComponent().getAttributes()
				.get("tipoprodutoSelecionado");

	}
}