package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.dao.CadeiaDAO;
import br.com.fiap.entity.Cadeia;

public class CadeiaDAOImpl extends GenericDAOImpl<Cadeia, Integer> implements CadeiaDAO{

	public CadeiaDAOImpl(EntityManager em) {
		super(em);
	}

}
