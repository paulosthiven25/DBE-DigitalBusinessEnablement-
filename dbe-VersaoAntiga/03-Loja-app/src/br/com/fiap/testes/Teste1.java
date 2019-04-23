package br.com.fiap.testes;

import br.com.fiap.singleton.ConfiguraçaoSingleton;

public class Teste1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String loja = ConfiguraçaoSingleton.getInstance().getProperty("nomefilial");
		System.out.println(loja);
	}

}
