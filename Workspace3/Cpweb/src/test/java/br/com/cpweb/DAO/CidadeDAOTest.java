package br.com.cpweb.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.cpweb.domain.Cidade;
import br.com.cpweb.domain.Estado;
import br.com.cpweb.domain.Pais;

public class CidadeDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		PaisDAO paisDAO = new PaisDAO();
		Pais pais = paisDAO.buscar(1L);
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(1L);
		
		Cidade cidade = new Cidade();
		cidade.setCdcidade("000001");
		cidade.setNome("Teresopolis");
		cidade.setUf(estado);
		cidade.setPais(pais);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
	
	@Test
	@Ignore
	public void listar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		
		for (Cidade cidade : resultado){
			System.out.println("Código da cidade: " + cidade.getCodigo());
			System.out.println("Nome da cidade: " + cidade.getNome());
			System.out.println("Código do estado: " + cidade.getUf().getCduf());
			System.out.println("Nome do estado: " + cidade.getUf().getNome());
			System.out.println("Código do país: " + cidade.getPais().getCdpais());
			System.out.println("Nome do país: " + cidade.getPais().getNome());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
	
			System.out.println("Código da cidade: " + cidade.getCodigo());
			System.out.println("Nome da cidade: " + cidade.getNome());
			System.out.println("Código do estado: " + cidade.getUf().getCduf());
			System.out.println("Nome do estado: " + cidade.getUf().getNome());
			System.out.println("Código do país: " + cidade.getPais().getCdpais());
			System.out.println("Nome do país: " + cidade.getPais().getNome());
		}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		cidadeDAO.excluir(cidade);
		
		System.out.println("Cidade removida:");
		System.out.println("Código da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("Código do estado: " + cidade.getUf().getCduf());
		System.out.println("Nome do estado: " + cidade.getUf().getNome());
		System.out.println("Código do país: " + cidade.getPais().getCdpais());
		System.out.println("Nome do país: " + cidade.getPais().getNome());
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoCidade = 2L;
		Long codigoEstado = 3L;
				

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		System.out.println("Código do estado: " + estado.getCduf());
		System.out.println("Nome do estado: " + estado.getNome());
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		System.out.println("Cidade a ser editada:");
		System.out.println("Código da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("Código do estado: " + cidade.getUf().getCduf());
		System.out.println("Nome do estado: " + cidade.getUf().getNome());
		System.out.println("Código do país: " + cidade.getPais().getCdpais());
		System.out.println("Nome do país: " + cidade.getPais().getNome());
		
		cidade.setNome("Lambari");
		cidade.setUf(estado);
		cidadeDAO.editar(cidade);
		
		System.out.println("Cidade editada:");
		System.out.println("Código da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("Código do estado: " + cidade.getUf().getCduf());
		System.out.println("Nome do estado: " + cidade.getUf().getNome());
		System.out.println("Código do país: " + cidade.getPais().getCdpais());
		System.out.println("Nome do país: " + cidade.getPais().getNome());
	}
	}

