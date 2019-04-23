package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="T_TRANSPORTE")
@SequenceGenerator(name="onibus",sequenceName="SQ_T_TRANSPORTE",allocationSize=1)
public class Onibus {
	@Id
	@GeneratedValue(generator="onibus",strategy=GenerationType.SEQUENCE)
	private int id;
	private String nome;
	@Temporal(TemporalType.DATE)
	private Calendar dataFabricacao;
	private boolean operando;
	
	
	
	
	public Onibus(int id, String nome, Calendar dataFabricacao, boolean operando) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataFabricacao = dataFabricacao;
		this.operando = operando;
	}
	public Onibus(String nome, Calendar dataFabricacao, boolean operando) {
		super();
		this.nome = nome;
		this.dataFabricacao = dataFabricacao;
		this.operando = operando;
	}
	public Onibus() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	public boolean isOperando() {
		return operando;
	}
	public void setOperando(boolean operando) {
		this.operando = operando;
	}
	
	

}
