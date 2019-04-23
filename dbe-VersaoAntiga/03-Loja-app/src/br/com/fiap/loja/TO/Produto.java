package br.com.fiap.loja.TO;

public class Produto {
	private int codigo;
	private double preço;
	private int quantidade;
	private String descrição;
	
	
	public Produto() {
		super();
	}
	
   public String getALL() {
return "Código: "+getCodigo()+"\n"+
		"Preço: "+getPreço()+"\n"+
		"Quantidade: "+getQuantidade()+"\n"+
		"Desscrição: "+getDescrição();
}
	
	
	public Produto(int codigo, double preço, int quantidade, String descrição) {
		super();
		this.codigo = codigo;
		this.preço = preço;
		this.quantidade = quantidade;
		this.descrição = descrição;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPreço() {
		return preço;
	}
	public void setPreço(double preço) {
		this.preço = preço;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
}
