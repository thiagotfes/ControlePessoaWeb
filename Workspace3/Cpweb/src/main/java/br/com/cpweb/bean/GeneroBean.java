package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.GeneroDAO;
import br.com.cpweb.domain.Genero;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GeneroBean implements Serializable {
	private Genero genero;
	private List<Genero> generos;
	

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	// Métodos liscar, buscar, gravar, editar e excluir
	@PostConstruct
	public void listar() {
		try {
			GeneroDAO generoDAO = new GeneroDAO();
			generos = generoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os generos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		genero = new Genero();
	}

	public void salvar() {
		try {
			GeneroDAO generoDAO = new GeneroDAO();
			generoDAO.merge(genero);
			novo();
			Messages.addGlobalInfo("Genero salvo com sucesso");
			generos = generoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o genero");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			genero = (Genero) evento.getComponent().getAttributes()
					.get("generoSelecionado");

			GeneroDAO generoDAO = new GeneroDAO();
			generoDAO.excluir(genero);
			generos = generoDAO.listar();

			Messages.addGlobalInfo("Genero removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o genero");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		genero = (Genero) evento.getComponent().getAttributes()
				.get("generoSelecionado");

	}
}