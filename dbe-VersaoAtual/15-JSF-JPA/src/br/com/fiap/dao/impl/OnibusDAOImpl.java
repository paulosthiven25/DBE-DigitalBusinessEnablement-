package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.OnibusDAO;
import br.com.fiap.entity.Onibus;

public class OnibusDAOImpl extends GenericDAOImpl<Onibus, Integer> implements OnibusDAO{

	public OnibusDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public List<Onibus> retornarPorNome(String nome){
		return em.createQuery("from Onibus o where o.nome = :nom ",Onibus.class).setParameter("nom",nome).getResultList();
		
	}

}
