package br.com.fiap.revisao.dao;

import br.com.fiap.revisao.bean.Pessoa;

public interface PessoaDAO {
	//ASSINATURAS DOS M�TODOS
		void gravar(Pessoa pessoa);
		void atualizar(Pessoa pessoa);
}
