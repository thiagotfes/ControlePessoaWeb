package br.com.cpweb.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class PessoaResourceConfig extends ResourceConfig {
	public PessoaResourceConfig(){
		packages("br.com.cpweb.service");
	}

}
