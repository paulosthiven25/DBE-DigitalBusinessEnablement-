package br.com.fiap.loja.TO;

public class Produto {
	private int codigo;
	private double preco;
	private int quantidade;
	private String descricao;
	
	
	public Produto() {
		super();
	}
	
	
	
   public String getALL() {
return "Código: "+getCodigo()+"\n"+
		"Preco: "+getPreco()+"\n"+
		"Quantidade: "+getQuantidade()+"\n"+
		"Desscricao: "+getDescricao();
}
	
	
	public Produto(int codigo, double preco, int quantidade, String descricao) {
		super();
		this.codigo = codigo;
		this.preco = preco;
		this.quantidade = quantidade;
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
