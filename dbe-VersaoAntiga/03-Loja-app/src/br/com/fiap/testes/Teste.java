package br.com.fiap.testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import br.com.fiap.loja.BO.EstoqueBO;
import br.com.fiap.loja.TO.Produto;
import br.com.fiap.singleton.ConfiguraçaoSingleton;

public class Teste {
	private static Logger log = Logger.getLogger(Teste.class); 
	public static void main(String[] args) {
		log.warn("Incio");
		String opcao ;
		Scanner sc = new Scanner(System.in);
		EstoqueBO ebo = new EstoqueBO();
		
		String loja = ConfiguraçaoSingleton.getInstance().getProperty("nomefilial");
		System.out.println(loja);
		
	do{int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do código"));
		Produto p = ebo.consultarProduto(codigo);
	if(p.getPreço()==0) {
		System.out.println("Produto não identificado");
		log.error("Produto inexistente");
	}
	else {
	System.out.println(p.getALL());
	}
	
	System.out.println("Deseja continuar?");
	opcao=sc.nextLine();
	log.debug("reinicio com sucesso");
	}while(opcao.toUpperCase().equals("S"));
	}

}
