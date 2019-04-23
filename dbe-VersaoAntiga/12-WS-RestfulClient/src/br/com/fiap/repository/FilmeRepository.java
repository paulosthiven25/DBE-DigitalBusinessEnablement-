package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.TO.Filme;

public class FilmeRepository {
	
	private Client client = Client.create();
	private static final String URL = "http://localhost:8080/11-WS-Restful/rest/filme/";
	
	public void cadastrar(Filme filme)throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,filme);
		
		//valida o status http da resposta
				if(resp.getStatus()!=201) {
					throw new Exception("Ero ao conectar no servidor");	
					
					
					
				}
				
	}
	
	public List<Filme>listar()throws Exception{
		Client client =Client.create();
		
		WebResource resource = client.resource("http://localhost:8080/11-WS-Restful/rest/filme");
		
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		//valida o status http da resposta
		if(resp.getStatus()==200) {
			Filme[] filmes = resp.getEntity(Filme[].class);
			return  Arrays.asList(filmes);
		}
		else{
			throw new Exception("Ero ao conectar no servidor");
		}
	}
	public Filme buscar(int codigo) throws Exception { 
		Client client =Client.create();
		
		WebResource resource = client.resource("http://localhost:8080/11-WS-Restful/rest/filme/").path(String.valueOf(codigo));
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(resp.getStatus()==200) {
			Filme f = resp.getEntity(Filme.class);
			return  f;
		}
		else{
			throw new Exception("Ero ao conectar no servidor");
		}
		
	}
	
	public void atualizar(Filme f) throws Exception{
		WebResource resource = client.resource(URL).path(String.valueOf(f.getCodigo()));
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class,f);
		
		//valida o status http da resposta
		if(resp.getStatus()!=200) {
			throw new Exception("Ero ao conectar no servidor");	
			}
		
	}
	
	public void remover(int codigo) throws Exception{
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse resp = resource.delete(ClientResponse.class);
		
		if(resp.getStatus()!=204) {
			throw new Exception();
		}
	}
	
	
}
