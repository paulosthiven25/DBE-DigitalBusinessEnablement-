package br.com.fiap.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.ImpostoBOStub;
import br.com.fiap.bo.ImpostoBOStub.CalcularImpostoIRPF;
import br.com.fiap.bo.ImpostoBOStub.CalcularImpostoIRPFResponse;

public class ConsoleView {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		
		//Criar o objeto que acessa o web service
		try {
			ImpostoBOStub stub = new ImpostoBOStub();
			//Objeto que armazenar os valores enviados para o servidor
			CalcularImpostoIRPF valores = new CalcularImpostoIRPF();	
			System.out.println("Digite a renda:");
			valores.setRenda(sc.nextDouble());
			//chama o web service
		CalcularImpostoIRPFResponse resp=	stub.calcularImpostoIRPF(valores);
		System.out.println("O valor do imposto é: "+resp.get_return());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Por favor,tente mais tarde");
			e.printStackTrace();
		}
		
		
		
		
		
		
		sc.close();
	}

}
