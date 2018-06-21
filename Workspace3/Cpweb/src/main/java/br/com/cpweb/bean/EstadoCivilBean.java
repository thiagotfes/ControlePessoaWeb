package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.EstadoCivilDAO;
import br.com.cpweb.domain.EstadoCivil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoCivilBean implements Serializable {
	private EstadoCivil estadocivil;
	private List<EstadoCivil> estadoscivis;

	public EstadoCivil getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(EstadoCivil estadocivil) {
		this.estadocivil = estadocivil;
	}

	public List<EstadoCivil> getEstadoscivis() {
		return estadoscivis;
	}

	public void setEstadoscivis(List<EstadoCivil> estadoscivis) {
		this.estadoscivis = estadoscivis;
	}

	// Métodos liscar, buscar, gravar, editar e excluir
	@PostConstruct
	public void listar() {
		try {
			EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
			estadoscivis = estadoCivilDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados civis");
			erro.printStackTrace();
		}
	}

	public void novo() {
		estadocivil = new EstadoCivil();
	}

	public void salvar() {
		try {
			EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
			estadoCivilDAO.merge(estadocivil);
			novo();
			Messages.addGlobalInfo("Estado Civil salvo com sucesso");
			estadoscivis = estadoCivilDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado civil");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			estadocivil = (EstadoCivil) evento.getComponent().getAttributes()
					.get("estadocivilSelecionado");

			EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
			estadoCivilDAO.excluir(estadocivil);
			estadoscivis = estadoCivilDAO.listar();

			Messages.addGlobalInfo("Estado Civil removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o estado civil");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		estadocivil = (EstadoCivil) evento.getComponent().getAttributes()
				.get("estadocivilSelecionado");

	}
}