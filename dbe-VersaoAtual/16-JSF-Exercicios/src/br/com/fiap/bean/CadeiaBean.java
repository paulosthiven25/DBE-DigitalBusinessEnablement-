package br.com.fiap.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.CadeiaDAO;
import br.com.fiap.dao.impl.CadeiaDAOImpl;
import br.com.fiap.entity.Cadeia;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadeiaBean {
	
	private CadeiaDAO cdao;
	private Cadeia cad;
	
	@PostConstruct
	public void inicializar () {
		cad=new Cadeia();
		cdao=new CadeiaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
		cad.setDataInauguracao(Calendar.getInstance());
	}
	
	private void addMessage(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//manter as mensagens após redirect
		FacesContext.getCurrentInstance().getExternalContext()
									.getFlash().setKeepMessages(true);
	}
	
	public void cadastar() {
		try {
			if (cad.getCodigo() == 0) {
				cdao.cadastrar(cad);
				cdao.commit();
				addMessage("Cadastrado!");
			}else {
				cdao.atualizar(cad);
				cdao.commit();
				addMessage("Atualizado!");
			}
			return "listagem?faces-redirect=true"; //navega para a página de listagem (nome do arquivo)
		} catch (CommitException e) {
			e.printStackTrace();
			addMessage("Erro..");
			return "cadastro";
		}
	}
	
	public List<Cadeia> listar(){
		
		return cdao.listar();
		
	}

}
