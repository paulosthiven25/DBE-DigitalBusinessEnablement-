package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.OnibusDAO;
import br.com.fiap.dao.impl.OnibusDAOImpl;
import br.com.fiap.entity.Onibus;
import br.com.fiap.singleton.EntityManagerFactorySingleton;



@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OnibusBean implements Serializable {
	private OnibusDAO odao;
	private Onibus o;
	
	@PostConstruct
	public void init() {
		o = new Onibus();
	odao = new OnibusDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	o.setDataFabricacao(Calendar.getInstance());
	}
	
	public List<Onibus> listar (){
		try {
			return odao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public void cadastrar() {
		FacesMessage msg;
		try {
			odao.cadastrar(o);
			msg = new FacesMessage("Cadastrado!");
			odao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public Onibus getO() {
		return o;
	}
	public void setO(Onibus o) {
		this.o = o;
	}
	
	

}
