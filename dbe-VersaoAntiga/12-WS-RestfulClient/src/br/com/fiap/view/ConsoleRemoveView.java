package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.TO.Filme;
import br.com.fiap.exception.CodigoNaoEncontradoException;
import br.com.fiap.repository.FilmeRepository;

public class ConsoleRemoveView {

	public static void main(String[] args) throws CodigoNaoEncontradoException {
		// TODO Auto-generated method stub
		FilmeRepository rep = new FilmeRepository(); 
		
		Scanner sc = new Scanner(System.in);
		int codigo=0;
		System.out.println("Digite um codigo:");
		codigo=sc.nextInt();
		
		try {
			rep.remover(codigo);
			System.out.println("deu bom");
		} catch (Exception e) {
			e.printStackTrace();
			throw new CodigoNaoEncontradoException("Deu ruim");
		}
	}

}
