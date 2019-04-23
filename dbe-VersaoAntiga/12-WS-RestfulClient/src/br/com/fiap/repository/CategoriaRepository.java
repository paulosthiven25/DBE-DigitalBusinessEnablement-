package br.com.fiap.repository;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.TO.Categoria;

public class CategoriaRepository {
	private Client client = Client.create();
	private static final String URL = "http://localhost:8080/11-WS-Restful/rest/categoria/";
	
	public void cadastrar(Categoria cate)throws Exception{
		WebResource resource = client.resource(URL);
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,cate);
		
		if(resp.getStatus()!=201) {
			throw new Exception("ERRO AÍ MANO");
		}
	}
}
