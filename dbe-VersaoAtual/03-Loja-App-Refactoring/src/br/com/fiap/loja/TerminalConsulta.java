package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.loja.singleton.LojaSingleton;
import br.com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {

	private static Logger log = Logger.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) {
		log.warn("In�cio da aplica��o");
		Scanner sc = new Scanner(System.in);

		// Data atual
		Calendar data = Calendar.getInstance();
		// Formatar a data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		EstoqueBO bo = new EstoqueBO();
		int codigo;
		
		//Recuperar a configura��o
		String loja = LojaSingleton.getInstance().getProperty("filial");
		do {

			System.out.println(loja + " - " + sdf.format(data.getTime()));
			// Ler um c�digo do produto
			System.out.print("Digite o c�digo do produto: ");
			codigo = sc.nextInt();			
			ProdutoTO to = bo.consultarProduto(codigo);
			
			if (to != null)
				System.out.println(to);
			else {
				System.out.println("Produto n�o encontrado!\n");
				log.error("C�digo n�o existente");
			}
			
		} while (codigo != 0);
		
		sc.close();
		log.warn("Final da aplica��o");
	}

}
