package br.com.fiap.TO;



public class Categoria {
	private int codigo;
	
	private String nome;

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
