package br.com.fiap.singleton;

import java.io.IOException;
import java.util.Properties;

public class Configura�aoSingleton {
//1- atributos est�ticos que ser� �nico na aplica��o
	private static Properties prop;
	
	//2-Construtor privado
	private Configura�aoSingleton() {}
	
	//3-m�todo est�tico getInstance
	public static Properties getInstance() {
		if(prop==null) {
			prop=new Properties();
			try {
			//carregar o objeto com os dados do arquivo
			prop.load(Configura�aoSingleton.class.getResourceAsStream("/configuracao.properties"));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return prop;
		
	}
}
