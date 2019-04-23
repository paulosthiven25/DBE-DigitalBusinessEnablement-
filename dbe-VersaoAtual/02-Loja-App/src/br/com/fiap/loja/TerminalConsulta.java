package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Data atual
		Calendar data = Calendar.getInstance();
		// Formatar a data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int codigo;
		do {

			System.out.println("FIAPStore - " + sdf.format(data.getTime()));
			// Ler um c�digo do produto
			System.out.print("Digite o c�digo do produto: ");
			codigo = sc.nextInt();

			switch (codigo) {
			case 401:
				System.out.println("Camiseta branca");
				break;
			case 402:
				System.out.println("Camiseta azul");
				break;
			case 403:
				System.out.println("Camiseta rosa");
				break;
			case 0:
				System.out.println("At� logo!");
				break;
			default:
				System.out.println("Produto n�o encontrado");
			}

		} while (codigo != 0);
		
		sc.close();
	}

}
