package br.com.cpweb.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.cpweb.domain.Pais;

public class PaisDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Pais pais = new Pais();
		pais.setCdpais("000001");
		pais.setNome("Brasil");

		PaisDAO paisDAO = new PaisDAO();
		paisDAO.salvar(pais);
	}

	@Test
	@Ignore
	public void listar() {
		PaisDAO paisDAO = new PaisDAO();
		List<Pais> resultado = paisDAO.listar();

		System.out.println("Total de registro: " + resultado.size());

		for (Pais pais : resultado) {
			System.out.println(pais.getCdpais() + " - " + pais.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		PaisDAO paisDAO = new PaisDAO();
		Pais pais = paisDAO.buscar(codigo);

		if (pais == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(pais.getCdpais() + " - " + pais.getNome());
		}

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		PaisDAO paisDAO = new PaisDAO();
		Pais pais = paisDAO.buscar(codigo);
		
		if (pais == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			paisDAO.excluir(pais);
			System.out.println("Registro removido:");
			System.out.println(pais.getCdpais() + " - " + pais.getNome());
		}

	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 4L;
		PaisDAO paisDAO = new PaisDAO();
		Pais pais = paisDAO.buscar(codigo);
		if (pais == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro antes:");
			System.out.println(pais.getCdpais() + " - " + pais.getNome());
			
			pais.setCdpais("000002");
			pais.setNome("Japao");
			paisDAO.editar(pais);
			
			System.out.println("Registro editado:");
			System.out.println(pais.getCdpais() + " - " + pais.getNome());
		}
	}
	
	@Test
	@Ignore
	public void merge() {
		Pais pais = new Pais();
		pais.setCdpais("000003");
		pais.setNome("Estados Unidos");
		PaisDAO paisDAO = new PaisDAO();
		paisDAO.merge(pais);
	}
}