package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.TipoPessoaDAO;
import br.com.cpweb.domain.TipoPessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TipoPessoaBean implements Serializable {
	private TipoPessoa tipopessoa;
	private List<TipoPessoa> tipospessoas;

	public TipoPessoa getTipopessoa() {
		return tipopessoa;
	}

	public void setTipopessoa(TipoPessoa tipopessoa) {
		this.tipopessoa = tipopessoa;
	}

	public List<TipoPessoa> getTipospessoas() {
		return tipospessoas;
	}

	public void setTipospessoas(List<TipoPessoa> tipospessoas) {
		this.tipospessoas = tipospessoas;
	}

	// Métodos liscar, buscar, gravar, editar e excluir
	@PostConstruct
	public void listar() {
		try {
			TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
			tipospessoas = tipoPessoaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os tipos de pessoas");
			erro.printStackTrace();
		}
	}

	public void novo() {
		tipopessoa = new TipoPessoa();
	}

	public void salvar() {
		try {
			TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
			tipoPessoaDAO.merge(tipopessoa);
			novo();
			Messages.addGlobalInfo("Tipo de Pessoa salvo com sucesso");
			tipospessoas = tipoPessoaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o tipo de pessoa");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			tipopessoa = (TipoPessoa) evento.getComponent().getAttributes()
					.get("tipopessoaSelecionada");

			TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
			tipoPessoaDAO.excluir(tipopessoa);
			tipospessoas = tipoPessoaDAO.listar();

			Messages.addGlobalInfo("Tipo de Pessoa removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o tipo de pessoa");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		tipopessoa = (TipoPessoa) evento.getComponent().getAttributes()
				.get("tipopessoaSelecionada");

	}
}