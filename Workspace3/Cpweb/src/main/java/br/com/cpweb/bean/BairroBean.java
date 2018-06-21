package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.BairroDAO;
import br.com.cpweb.DAO.CidadeDAO;
import br.com.cpweb.DAO.EstadoDAO;
import br.com.cpweb.DAO.PaisDAO;
import br.com.cpweb.domain.Bairro;
import br.com.cpweb.domain.Cidade;
import br.com.cpweb.domain.Estado;
import br.com.cpweb.domain.Pais;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BairroBean implements Serializable {
	private Bairro bairro;
	private List<Bairro> bairros;
	private List<Cidade> cidades;
	private List<Estado> estados;
	private List<Pais> paises;

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
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
			BairroDAO bairroDAO = new BairroDAO();
			bairros = bairroDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os bairros");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			bairro = new Bairro();

			BairroDAO bairroDAO = new BairroDAO();
			bairros = bairroDAO.listar();
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			PaisDAO paisDAO = new PaisDAO();
			paises = paisDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo bairro");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			BairroDAO bairroDAO = new BairroDAO();
			bairroDAO.merge(bairro);

			bairro = new Bairro();

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

			PaisDAO paisDAO = new PaisDAO();
			paises = paisDAO.listar();

			bairros = bairroDAO.listar();

			Messages.addGlobalInfo("Bairro salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o bairro");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			bairro = (Bairro) evento.getComponent().getAttributes()
					.get("bairroSelecionado");

			BairroDAO bairroDAO = new BairroDAO();
			bairroDAO.excluir(bairro);
			bairros = bairroDAO.listar();

			Messages.addGlobalInfo("Bairro removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o bairro");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			bairro = (Bairro) evento.getComponent().getAttributes()
					.get("bairroSelecionado");
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			PaisDAO paisDAO = new PaisDAO();
			paises = paisDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar um bairro");
			erro.printStackTrace();
		}
	}
}
