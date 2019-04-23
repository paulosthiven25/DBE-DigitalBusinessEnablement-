package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CATEGORIA")
@SequenceGenerator(name="categ",sequenceName="SQ_T_CATEGORIA",allocationSize=1)
public class Categoria {
	@Id
	@GeneratedValue(generator="categ",strategy=GenerationType.SEQUENCE)
	@Column(name="CD_CATEGORIA")
	private int codigo;
	@Column(name="NM_CATEGORIA",nullable=false)
	private String nome;
	@Column(name="DS_CATEGORIA",nullable=false)
	private int classificacao;
	
	
	
	public Categoria(int codigo, String nome, int classificacao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.classificacao = classificacao;
	}
	public Categoria(String nome, int classificacao) {
		super();
		this.nome = nome;
		this.classificacao = classificacao;
	}
	public Categoria() {
		super();
	}
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
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	
	

}
