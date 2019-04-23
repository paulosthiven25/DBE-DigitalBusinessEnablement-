package br.com.fiap.teste;


import org.apache.log4j.Logger;


import br.com.fiap.singleton.Configura�aoSingleton;

public class Teste {
	private static Logger log=Logger.getLogger(Teste.class);

	public static void main(String[] args) {
		log.info("Iniciando a aplica��o");
		//recuperar a configura��o de idioma
		String idioma = Configura�aoSingleton.getInstance().getProperty("ambiente");
		System.out.println(idioma);
		log.warn("Recuperamdp a configurac�o do sistema de desenvolvimento");

	}

}
