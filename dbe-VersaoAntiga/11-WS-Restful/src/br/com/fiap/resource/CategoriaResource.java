package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.dao.impl.CategoriaDAOImpl;
import br.com.fiap.entity.Categoria;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
@Path("/Categoria")
public class CategoriaResource {
	


	private CategoriaDAO dao;

	public CategoriaResource() {
	
		dao =new CategoriaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Categoria categ,@Context UriInfo uri) {
		try {
			dao.cadastrar(categ);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		//Criar a URL para acessar o recurso (filme) cadastrado.
				UriBuilder url = uri.getAbsolutePathBuilder();
				//Adiviona na url o codigo do filme cadastrado
				url.path(Integer.toString(categ.getCodigo()));
				//retorna o codigo 201 created e a url para o filme cadastrado.
				return Response.created(url.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> listar (){
		return dao.listar();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Categoria buscar(@PathParam("id") int codigo){
		return dao.buscar(codigo);
	}
	
}

