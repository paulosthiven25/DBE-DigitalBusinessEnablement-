package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.TO.Filme;
import br.com.fiap.repository.FilmeRepository;

public class ConsoleCadastroView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o filme: ");
		String nome = sc.next()+sc.nextLine();
		
		System.out.println("Digite a dura��o: ");
		int duracao = sc.nextInt();
		
		System.out.println("Est� em cartaz?: ");
		boolean cartaz = sc.nextBoolean();
		
		Filme filme = new Filme(0,nome,duracao,cartaz);
		FilmeRepository rep = new FilmeRepository();
		
		try {
			rep.cadastrar(filme);
			System.out.println("Deu bom p�");
		} catch (Exception e) {
			e.printStackTrace();
		}
			sc.close();
	}

}
