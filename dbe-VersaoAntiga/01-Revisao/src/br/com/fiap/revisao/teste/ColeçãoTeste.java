package br.com.fiap.revisao.teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.fiap.revisao.bean.Funcionario;
import br.com.fiap.revisao.bean.Pessoa;

public class ColeçãoTeste {

	public static void main(String[] args) {
		//criar uma lista
		List<Pessoa> lista = new ArrayList<Pessoa>();
		//add um elemento na lisrta
		lista.add(new Funcionario("Paulo"));
		lista.add(new Pessoa("Rodrigo"));
		
		//percorer  a lista
		System.out.println("LIST");
		for(Pessoa p:lista) {
			System.out.println(p.getNome());
		}
		
		//criando um set
		System.out.println("SET");
		Set<String> set = new HashSet<>();
		set.add("Alice");
		set.add("Rafael");
		set.add("Rafael");
		
		for(String s : set) {
			System.out.println(s);
		}
		
		//criando um map
		Map<String,Pessoa> map = new HashMap<>();
		//add valores para o mapa
		map.put("gerente",new Funcionario("Rita"));
		map.put("cliente",new Pessoa("Ronaldo"));
		
		//
		System.out.println(map.get("gerente").getNome());

	}

}
