package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="cadeia",allocationSize=1,sequenceName="SQ_T_CADEIA")
public class Cadeia {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cadeia")
	private int codigo;
	
	private String nome;
	
	private Calendar dataInauguracao;
	
	private boolean segurancaMaxima;
	
	private int capacidade;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataInauguracao() {
		return dataInauguracao;
	}

	public void setDataInauguracao(Calendar dataInauguracao) {
		this.dataInauguracao = dataInauguracao;
	}

	public boolean isSegurancaMaxima() {
		return segurancaMaxima;
	}

	public void setSegurancaMaxima(boolean segurancaMaxima) {
		this.segurancaMaxima = segurancaMaxima;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
}
