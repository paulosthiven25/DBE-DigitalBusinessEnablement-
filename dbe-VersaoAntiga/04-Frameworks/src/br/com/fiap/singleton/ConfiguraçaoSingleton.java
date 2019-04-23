package br.com.fiap.singleton;

import java.io.IOException;
import java.util.Properties;

public class ConfiguraçaoSingleton {
//1- atributos estáticos que será único na aplicação
	private static Properties prop;
	
	//2-Construtor privado
	private ConfiguraçaoSingleton() {}
	
	//3-método estático getInstance
	public static Properties getInstance() {
		if(prop==null) {
			prop=new Properties();
			try {
			//carregar o objeto com os dados do arquivo
			prop.load(ConfiguraçaoSingleton.class.getResourceAsStream("/configuracao.properties"));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return prop;
		
	}
}
