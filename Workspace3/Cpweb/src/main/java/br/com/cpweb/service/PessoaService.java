package br.com.cpweb.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("cpweb")
public class PessoaService {
	@GET
	public String exibir(){
		return "Controle de Pessoa Web";
	}

}
