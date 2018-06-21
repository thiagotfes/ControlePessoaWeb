package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.GrupoProdutoDAO;
import br.com.cpweb.domain.GrupoProduto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoProdutoBean implements Serializable {
	private GrupoProduto grupoproduto;
	private List<GrupoProduto> gruposprodutos;


	public GrupoProduto getGrupoproduto() {
		return grupoproduto;
	}

	public void setGrupoproduto(GrupoProduto grupoproduto) {
		this.grupoproduto = grupoproduto;
	}

	public List<GrupoProduto> getGruposprodutos() {
		return gruposprodutos;
	}

	public void setGruposprodutos(List<GrupoProduto> gruposprodutos) {
		this.gruposprodutos = gruposprodutos;
	}

	// Métodos liscar, buscar, gravar, editar e excluir
	@PostConstruct
	public void listar() {
		try {
			GrupoProdutoDAO grupoprodutoDAO = new GrupoProdutoDAO();
			gruposprodutos = grupoprodutoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os grupos de produtos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		grupoproduto = new GrupoProduto();
	}

	public void salvar() {
		try {
			GrupoProdutoDAO grupoProdutoDAO = new GrupoProdutoDAO();
			grupoProdutoDAO.merge(grupoproduto);
			novo();
			Messages.addGlobalInfo("Grupo de produto salvo com sucesso");
			gruposprodutos = grupoProdutoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o grupo de produto");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			grupoproduto = (GrupoProduto) evento.getComponent().getAttributes()
					.get("grupoProdutoSelecionado");

			GrupoProdutoDAO grupoProdutoDAO = new GrupoProdutoDAO();
			grupoProdutoDAO.excluir(grupoproduto);
			gruposprodutos = grupoProdutoDAO.listar();

			Messages.addGlobalInfo("Grupo de produto removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o grupo de produto");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		grupoproduto = (GrupoProduto) evento.getComponent().getAttributes()
				.get("grupoProdutoSelecionado");

	}
}