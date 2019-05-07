package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T,K> {

	void cadastrar(T tabela);
	
	void remover(K codigo) throws CodigoInexistenteException ;
	
	void atualizar(T tabela);
	
	T buscar(K codigo);
	
	List<T> listar();
	
	void commit() throws CommitException ;
	
}
