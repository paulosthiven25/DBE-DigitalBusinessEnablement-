package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.to.Cliente;

@ManagedBean
public class ClienteBean {

	private Cliente cliente;
	
	private ClienteBO bo;
	
	@PostConstruct //método que é executado antes de tudo
	public void iniciar() {
		bo = new ClienteBO();
		cliente = new Cliente();
	}
	
	public List<Cliente> listar(){
		return bo.listar();
	}
	
	public void cadastrar() {
		bo.cadastrar(cliente);
		//Exibir a mensagem
		FacesMessage msg = new FacesMessage("Usuário cadastrado!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}


