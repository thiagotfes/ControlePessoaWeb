package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.ClassificacaoDAO;
import br.com.cpweb.domain.Classificacao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClassificacaoBean implements Serializable {
	private Classificacao classificacao;
	private List<Classificacao> classificacoes;

	// Métodos getters e setters
	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public List<Classificacao> getClassificacoes() {
		return classificacoes;
	}

	public void setClassificacoes(List<Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}

	

	// Métodos liscar, buscar, gravar, editar e excluir
	@PostConstruct
	public void listar() {
		try {
			ClassificacaoDAO classificacaoDAO = new ClassificacaoDAO();
			classificacoes = classificacaoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as classificações");
			erro.printStackTrace();
		}
	}

	

	public void novo() {
		classificacao = new Classificacao();
	}

	public void salvar() {
		try {
			ClassificacaoDAO classificacaoDAO = new ClassificacaoDAO();
			classificacaoDAO.merge(classificacao);
			novo();
			Messages.addGlobalInfo("Classificação salva com sucesso");
			classificacoes = classificacaoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a classificação");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			classificacao = (Classificacao) evento.getComponent().getAttributes()
					.get("classificacaoSelecionada");

			ClassificacaoDAO classificacaoDAO = new ClassificacaoDAO();
			classificacaoDAO.excluir(classificacao);
			classificacoes = classificacaoDAO.listar();

			Messages.addGlobalInfo("classificação removida com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover a classificação");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		classificacao = (Classificacao) evento.getComponent().getAttributes()
				.get("classificacaoSelecionada");

	}
}
