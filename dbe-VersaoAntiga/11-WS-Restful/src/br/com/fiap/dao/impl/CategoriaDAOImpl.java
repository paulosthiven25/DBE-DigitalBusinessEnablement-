package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.entity.Categoria;

public class CategoriaDAOImpl extends GenericDAOImpl<Categoria,Integer> implements CategoriaDAO {

	public CategoriaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
