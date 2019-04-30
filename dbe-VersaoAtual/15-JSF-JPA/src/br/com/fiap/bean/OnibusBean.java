package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.fiap.dao.OnibusDAO;
import br.com.fiap.dao.impl.OnibusDAOImpl;
import br.com.fiap.entity.Onibus;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
@RequestScoped
public class OnibusBean implements Serializable {

	private Onibus onibus;
	
	private OnibusDAO dao;
	
	@PostConstruct
	public void init() {
		dao = new OnibusDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
		onibus = new Onibus();
		onibus.setDataFabricacao(Calendar.getInstance());
	}
	
	//public void validaNomeJaCadastrado().....
	
	public List<Onibus> listar(){
		return dao.listar();
	}
	
	public String excluir(int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
			addMessage("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
			addMessage("Erro");
		}
		return "lista-onibus?faces-redirect=true";
	}
	
	public String cadastrar() {
		try {
			if (onibus.getId() == 0) {
				dao.cadastrar(onibus);
				dao.commit();
				addMessage("Cadastrado!");
			}else {
				dao.atualizar(onibus);
				dao.commit();
				addMessage("Atualizado!");
			}
			return "lista-onibus?faces-redirect=true"; //navega para a página de listagem (nome do arquivo)
		} catch (CommitException e) {
			e.printStackTrace();
			addMessage("Erro..");
			return "cadastro-onibus";
		}
	}
	
	public void validaRepeticaoNome(FacesContext context, UIComponent component, Object value)
			throws ValidatorException{
		String valor = value.toString();
		List<Onibus> lista = dao.retornarPorNome(valor);
			if ((lista.size()>0)) { 
			throw new ValidatorException(new FacesMessage("Nome repetido"));
			}
			}
	
	private void addMessage(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//manter as mensagens após redirect
		FacesContext.getCurrentInstance().getExternalContext()
									.getFlash().setKeepMessages(true);
	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
	
}
