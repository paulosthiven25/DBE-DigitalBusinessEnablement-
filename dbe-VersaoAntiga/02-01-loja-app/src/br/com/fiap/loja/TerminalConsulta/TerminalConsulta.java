package br.com.fiap.loja.TerminalConsulta;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TerminalConsulta {

	public static void main(String[] args) {
		int codigo=0;
		Scanner sc=new Scanner(System.in);
		Calendar data = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		do {
		System.out.println("LojasRoup�o");
		System.out.println(sdf.format(data.getTime()));
	System.out.println("informe o c�digo do produto:");
	codigo=sc.nextInt();
	
	switch(codigo) {
	case 401:
		System.out.println("Camiseta branca");
		break;
		
	case 402:
		System.out.println("Camiseta azul");
		break;
		
	case 403:
		System.out.println("Camiseta rosa");
		break;
		
		default:System.out.println("Produto n�o encontrado");
	}
		}while(codigo<401 || codigo>403);

	}

}
