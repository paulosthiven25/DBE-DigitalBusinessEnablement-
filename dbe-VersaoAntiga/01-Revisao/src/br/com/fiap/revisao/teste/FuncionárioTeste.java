package br.com.fiap.revisao.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.revisao.bean.Funcionario;
import br.com.fiap.revisao.bean.Genero;

public class Funcion�rioTeste {
	public static void main(String args[]) {
		//instanciar um funcion�rio
		Funcionario f =new Funcionario("bolsoLula");
		
		//Atribuir uma data de admiss�o
		//data atual
		Calendar data2 = new GregorianCalendar(2018,Calendar.JANUARY,20);
		f.setDataAdmissao(Calendar.getInstance());
		
		//objeto para formatar a data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//exibir a data
		System.out.println(sdf.format(data2.getTime()));
		
		//exibir o genero
		System.out.println(f.getGenero());
		
		//atribuir um valor para o genero
		f.setGenero(Genero.MASCULINO);
	}
}
