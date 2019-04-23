package br.com.fiap.teste;


import org.apache.log4j.Logger;


import br.com.fiap.singleton.ConfiguraçaoSingleton;

public class Teste {
	private static Logger log=Logger.getLogger(Teste.class);

	public static void main(String[] args) {
		log.info("Iniciando a aplicação");
		//recuperar a configuração de idioma
		String idioma = ConfiguraçaoSingleton.getInstance().getProperty("ambiente");
		System.out.println(idioma);
		log.warn("Recuperamdp a configuracão do sistema de desenvolvimento");

	}

}
