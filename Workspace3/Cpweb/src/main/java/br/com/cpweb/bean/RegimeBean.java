package br.com.cpweb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.RegimeDAO;
import br.com.cpweb.domain.Regime;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RegimeBean implements Serializable {
	private Regime regime;
	private List<Regime> regimes;


	public Regime getRegime() {
		return regime;
	}

	public void setRegime(Regime regime) {
		this.regime = regime;
	}

	public List<Regime> getRegimes() {
		return regimes;
	}

	public void setRegimes(List<Regime> regimes) {
		this.regimes = regimes;
	}

	// Métodos liscar, buscar, gravar, editar e excluir
	@PostConstruct
	public void listar() {
		try {
			RegimeDAO regimeDAO = new RegimeDAO();
			regimes = regimeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os regimes de tributação");
			erro.printStackTrace();
		}
	}

	public void novo() {
		regime = new Regime();
	}

	public void salvar() {
		try {
			RegimeDAO regimeDAO = new RegimeDAO();
			regimeDAO.merge(regime);
			regime = new Regime();
			Messages.addGlobalInfo("Regime de tributação salvo com sucesso");
			regimes = regimeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o regime de tributação");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento){
		try {
		regime = (Regime) evento.getComponent().getAttributes().get("regimeSelecionado");
		
		RegimeDAO regimeDAO = new RegimeDAO();
		regimeDAO.excluir(regime);
		regimes = regimeDAO.listar();
		
		Messages.addGlobalInfo("Regime de tributação removido com sucesso");
		
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o regime de tributação");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		regime = (Regime) evento.getComponent().getAttributes().get("regimeSelecionado");

	}
}
