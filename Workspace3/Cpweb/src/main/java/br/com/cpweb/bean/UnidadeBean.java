package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.UnidadeDAO;
import br.com.cpweb.domain.Unidade;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UnidadeBean implements Serializable {
	private Unidade unidade;
	private List<Unidade> unidades;


	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	// Métodos liscar, buscar, gravar, editar e excluir
	@PostConstruct
	public void listar() {
		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO();
			unidades = unidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as unidades");
			erro.printStackTrace();
		}
	}

	public void novo() {
		unidade = new Unidade();
	}

	public void salvar() {
		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO();
			unidadeDAO.merge(unidade);
			novo();
			Messages.addGlobalInfo("Unidade salva com sucesso");
			unidades = unidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a unidade");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			unidade = (Unidade) evento.getComponent().getAttributes()
					.get("unidadeSelecionada");

			UnidadeDAO unidadeDAO = new UnidadeDAO();
			unidadeDAO.excluir(unidade);
			unidades = unidadeDAO.listar();

			Messages.addGlobalInfo("Unidade removida com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover a unidade");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		unidade = (Unidade) evento.getComponent().getAttributes()
				.get("unidadeSelecionada");

	}
}