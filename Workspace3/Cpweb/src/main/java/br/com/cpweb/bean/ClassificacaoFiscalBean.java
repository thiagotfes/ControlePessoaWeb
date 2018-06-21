package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.ClassificacaoFiscalDAO;
import br.com.cpweb.domain.ClassificacaoFiscal;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClassificacaoFiscalBean implements Serializable {
	private ClassificacaoFiscal classificacaofiscal;
	private List<ClassificacaoFiscal> classificacoesfiscais;



	public ClassificacaoFiscal getClassificacaofiscal() {
		return classificacaofiscal;
	}




	public void setClassificacaofiscal(ClassificacaoFiscal classificacaofiscal) {
		this.classificacaofiscal = classificacaofiscal;
	}




	public List<ClassificacaoFiscal> getClassificacoesfiscais() {
		return classificacoesfiscais;
	}




	public void setClassificacoesfiscais(
			List<ClassificacaoFiscal> classificacoesfiscais) {
		this.classificacoesfiscais = classificacoesfiscais;
	}




	@PostConstruct
	public void listar() {
		try {
			ClassificacaoFiscalDAO classificacaofiscalDAO = new ClassificacaoFiscalDAO();
			classificacoesfiscais = classificacaofiscalDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as classificações fiscais");
			erro.printStackTrace();
		}
	}




	public void novo() {
		classificacaofiscal = new ClassificacaoFiscal();
	}

	public void salvar() {
		try {
			ClassificacaoFiscalDAO classificacaofiscalDAO = new ClassificacaoFiscalDAO();
			classificacaofiscalDAO.merge(classificacaofiscal);
			novo();
			Messages.addGlobalInfo("Classificacao fiscal salva com sucesso");
			classificacoesfiscais = classificacaofiscalDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a classificação fiscal");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			classificacaofiscal = (ClassificacaoFiscal) evento.getComponent().getAttributes()
					.get("classificacaofiscalSelecionada");

			ClassificacaoFiscalDAO classificacaofiscalDAO = new ClassificacaoFiscalDAO();
			classificacaofiscalDAO.excluir(classificacaofiscal);
			classificacoesfiscais = classificacaofiscalDAO.listar();

			Messages.addGlobalInfo("Classificação fiscal removida com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover a classificação fiscal");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		classificacaofiscal = (ClassificacaoFiscal) evento.getComponent().getAttributes()
				.get("classificacaofiscalSelecionada");

	}
}
