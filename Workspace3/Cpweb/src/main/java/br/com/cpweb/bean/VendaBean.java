package br.com.cpweb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.cpweb.DAO.ClienteDAO;
import br.com.cpweb.DAO.FuncionarioDAO;
import br.com.cpweb.DAO.ProdutoDAO;
import br.com.cpweb.DAO.VendaDAO;
import br.com.cpweb.domain.Cliente;
import br.com.cpweb.domain.Funcionario;
import br.com.cpweb.domain.Produto;
import br.com.cpweb.domain.Venda;
import br.com.cpweb.domain.itemVenda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {
	private Venda venda;
	private List<Produto> produtos;
	private List<itemVenda> itensVenda;
	private List<Cliente> clientes;
	private List<Funcionario> funcionarios;
	
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<itemVenda> getItensVenda() {
		return itensVenda;
	}
	
	public void setItensVenda(List<itemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}
	
	@PostConstruct
	public void novo() {
		try {
			venda = new Venda();
			venda.setValorTotal(new BigDecimal("0.00"));
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar("descricao");
			
			itensVenda = new ArrayList<>();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar a tela de vendas");
			erro.printStackTrace();
		}
	}
	
	public void adicionar(ActionEvent evento){
		Produto produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

		int achou = -1;
		for(int posicao = 0; posicao < itensVenda.size(); posicao++){
			if(itensVenda.get(posicao).getProduto().equals(produto)){
				achou = posicao;
			}
		}
		
		if(achou < 0){
			itemVenda itemVenda = new itemVenda();
			itemVenda.setPrecoParcial(produto.getPreco());
			itemVenda.setProduto(produto);
			itemVenda.setQuantidade(new Short("1"));
			itensVenda.add(itemVenda);
		} else {
			itemVenda itemVenda = itensVenda.get(achou);
			itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() + 1 + ""));
			itemVenda.setPrecoParcial(produto.getPreco().multiply(new BigDecimal(itemVenda.getQuantidade())));
 		}
		
		calcular();
				
	}
	
	public void remover(ActionEvent evento){
		itemVenda itemVenda = (itemVenda) evento.getComponent().getAttributes().get("itemSelecionado");
		
		int achou = -1;
		for(int posicao = 0; posicao < itensVenda.size(); posicao++){
			if(itensVenda.get(posicao).getProduto().equals(itemVenda.getProduto())){
				achou = posicao;
			}
		}
		
		if(achou > -1){
			itensVenda.remove(achou);
		}
		
		calcular();
		
	}
	
	public void calcular(){
		venda.setValorTotal(new BigDecimal("0.00"));
		
		for(int posicao = 0; posicao < itensVenda.size(); posicao++){
			itemVenda itemvenda = itensVenda.get(posicao);
			venda.setValorTotal(venda.getValorTotal().add(itemvenda.getPrecoParcial()));
		}
		
	}
	
	public void finalizar(){
		try{
			venda.setHorario(new Date());
			venda.setClienteVenda(null);
			venda.setFuncionarioVenda(null);
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listarOrdenado();
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listarOrdenado();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar finalizar a venda");
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try {
			
			if(venda.getValorTotal().signum() == 0){
				Messages.addGlobalWarn("Informe pelo menos um item para finalizar a venda");
				return;
			}
			
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.salvar(venda, itensVenda);
			
			novo();
			
			Messages.addGlobalInfo("Venda realizada com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar finalizar a venda");
			erro.printStackTrace();
		}
	}
}
