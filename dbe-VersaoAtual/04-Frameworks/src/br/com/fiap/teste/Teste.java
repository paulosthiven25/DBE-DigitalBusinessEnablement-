package br.com.fiap.teste;

import org.apache.log4j.Logger;

import br.com.fiap.singleton.ConfiguracaoSingleton;

public class Teste {

	private static Logger log = Logger.getLogger(Teste.class);
	
	public static void main(String[] args) {
		
		log.info("Iniciando a aplica��o");
		
		//recuperar a configura��o de idioma
		String idioma = ConfiguracaoSingleton.getInstance().getProperty("ambiente");
		
		log.warn("Recuperando a configura��o do sistema");
		
		System.out.println(idioma);
	}
	
}

