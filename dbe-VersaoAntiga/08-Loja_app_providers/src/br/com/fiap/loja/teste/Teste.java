package br.com.fiap.loja.teste;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.Produto;

public class Teste {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Digite o número do produto");
		int codigo=sc.nextInt();
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			ConsultarProduto cs = new ConsultarProduto();
			cs.setCodigo(codigo);
			
			ConsultarProdutoResponse resposta = stub.consultarProduto(cs);
			
			
			Produto p = resposta.get_return();
			System.out.println(p.getDescricao());
			System.out.println("Preço: "+p.getPreco());
			System.out.println("QTD: "+p.getQuantidade());
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
