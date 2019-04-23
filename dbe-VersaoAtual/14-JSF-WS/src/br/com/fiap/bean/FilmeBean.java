package br.com.fiap.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.repository.FilmeRepository;
import br.com.fiap.to.Filme;

@ManagedBean
@ViewScoped
public class FilmeBean implements Serializable {

	private Filme filme;
	private FilmeRepository repository;
	
	@PostConstruct
	public void init() {
		filme = new Filme();
		repository = new FilmeRepository();
	}
	
	public List<Filme> listar(){
		try {
			return repository.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void atualizar() {
		FacesMessage msg;
		try {
			repository.atualizar(filme);
			msg = new FacesMessage("Atualizado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void cadastrar() {
		FacesMessage msg;
		try {
			repository.cadastrar(filme);
			msg = new FacesMessage("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	
	
}
