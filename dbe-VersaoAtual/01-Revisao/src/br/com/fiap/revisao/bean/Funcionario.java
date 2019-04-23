package br.com.fiap.revisao.bean;

import java.util.Calendar;

public class Funcionario extends Pessoa {
	
	//constante 
	//static -> atributo/m�todo da classe (n�o objeto)
	public static final String PREMIACAO_TOTAL = "10%"; 

	private float salario;
	
	private Calendar dataAdmissao;
	
	public Funcionario(String nome) {
		super(nome);
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	//sobrescrever o m�todo 
	@Override
	public boolean validarRm() {
		String rmStr = String.valueOf(rm);
		return (rmStr.length() == 7)?true:false;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
}






