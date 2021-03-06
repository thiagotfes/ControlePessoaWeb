package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.PaisDAO;
import br.com.cpweb.domain.Pais;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PaisBean implements Serializable {
	private Pais pais;
	private List<Pais> paises;

	// Métodos getters e setters
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	// Métodos liscar, buscar, gravar, editar e excluir
	@PostConstruct
	public void listar() {
		try {
			PaisDAO paisDAO = new PaisDAO();
			paises = paisDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os países");
			erro.printStackTrace();
		}
	}

	public void novo() {
		pais = new Pais();
	}

	public void salvar() {
		try {
			PaisDAO paisDAO = new PaisDAO();
			paisDAO.merge(pais);
			novo();
			Messages.addGlobalInfo("País salvo com sucesso");
			paises = paisDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o país");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento){
		try {
		pais = (Pais) evento.getComponent().getAttributes().get("paisSelecionado");
		
		PaisDAO paisDAO = new PaisDAO();
		paisDAO.excluir(pais);
		paises = paisDAO.listar();
		
		Messages.addGlobalInfo("País removido com sucesso");
		
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o país");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		pais = (Pais) evento.getComponent().getAttributes().get("paisSelecionado");

	}
}
