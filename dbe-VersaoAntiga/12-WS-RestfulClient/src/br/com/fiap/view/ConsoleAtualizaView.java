package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.TO.Filme;
import br.com.fiap.repository.FilmeRepository;

public class ConsoleAtualizaView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
		System.out.println("Digite um codigo:");
		int codigo=sc.nextInt();
	
		System.out.println("Digite o filme: ");
		String nome = sc.next()+sc.nextLine();
		
		System.out.println("Digite a duração: ");
		int duracao = sc.nextInt();
		
		System.out.println("Está em cartaz?: ");
		boolean cartaz = sc.nextBoolean();
		
		Filme filme = new Filme(codigo,nome,duracao,cartaz);
		FilmeRepository rep = new FilmeRepository();
		
		
		try {
			rep.atualizar(filme);
			System.out.println("Deu bom pô");
		} catch (Exception e) {
			e.printStackTrace();
		}
			sc.close();

	}

}
