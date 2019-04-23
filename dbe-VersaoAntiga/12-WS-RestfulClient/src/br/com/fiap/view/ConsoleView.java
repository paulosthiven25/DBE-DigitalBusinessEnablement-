package br.com.fiap.view;

import java.util.List;

import br.com.fiap.TO.Filme;
import br.com.fiap.repository.FilmeRepository;

public class ConsoleView {
	public static void main (String args[]) {
		FilmeRepository rep = new FilmeRepository(); 
		
		try {
			List<Filme> lista =rep.listar();
			for(Filme filme: lista) {
				System.out.println(filme.getCodigo()+"Titulo:"+filme.getNome()+"\n"+
			"Duração:"+filme.getDuracao()+"\n"+
			"Em cartaz:"+filme.isCartaz()			
						);
			}
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}

}
