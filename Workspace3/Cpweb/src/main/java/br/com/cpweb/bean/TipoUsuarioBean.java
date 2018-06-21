package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.TipoUsuarioDAO;
import br.com.cpweb.domain.TipoUsuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TipoUsuarioBean implements Serializable {
	private TipoUsuario tipousuario;
	private List<TipoUsuario> tiposusuarios;

	public TipoUsuario getTiposusuario() {
		return tipousuario;
	}

	public void setTiposusuario(TipoUsuario tiposusuario) {
		this.tipousuario = tiposusuario;
	}

	public List<TipoUsuario> getTiposusuarios() {
		return tiposusuarios;
	}

	public void setTiposusuarios(List<TipoUsuario> tiposusuarios) {
		this.tiposusuarios = tiposusuarios;
	}

	// Métodos liscar, buscar, gravar, editar e excluir
	@PostConstruct
	public void listar() {
		try {
			TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
			tiposusuarios = tipoUsuarioDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os tipos de usuários");
			erro.printStackTrace();
		}
	}

	public void novo() {
		tipousuario = new TipoUsuario();
	}

	public void salvar() {
		try {
			TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
			tipoUsuarioDAO.merge(tipousuario);
			novo();
			Messages.addGlobalInfo("Tipo de usuário salvo com sucesso");
			tiposusuarios = tipoUsuarioDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o tipo de usuário");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			tipousuario = (TipoUsuario) evento.getComponent().getAttributes()
					.get("tipousuarioSelecionado");

			TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
			tipoUsuarioDAO.excluir(tipousuario);
			tiposusuarios = tipoUsuarioDAO.listar();

			Messages.addGlobalInfo("Tipo de usuário removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o tipo de usuário");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		tipousuario = (TipoUsuario) evento.getComponent().getAttributes()
				.get("tipousuarioSelecionado");

	}
}