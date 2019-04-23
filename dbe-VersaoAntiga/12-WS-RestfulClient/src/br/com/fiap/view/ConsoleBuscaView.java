package br.com.fiap.view;


import java.util.Scanner;

import br.com.fiap.TO.Filme;
import br.com.fiap.repository.FilmeRepository;

public class ConsoleBuscaView {
	public static void main (String args[]) {
		FilmeRepository rep = new FilmeRepository(); 
		Filme f =new Filme();
		Scanner sc = new Scanner(System.in);
		int codigo=0;
		System.out.println("Digite um codigo:");
		codigo=sc.nextInt();
		try {
			f =rep.buscar(codigo);
			
				System.out.println("Titulo:"+f.getNome()+"\n"+
			"Duração:"+f.getDuracao()+"\n"+
			"Em cartaz:"+f.isCartaz()			
						);
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
}
