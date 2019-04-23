package br.com.fiap.loja.TO;

public class Produto {
	private int codigo;
	private double pre�o;
	private int quantidade;
	private String descri��o;
	
	
	public Produto() {
		super();
	}
	
   public String getALL() {
return "C�digo: "+getCodigo()+"\n"+
		"Pre�o: "+getPre�o()+"\n"+
		"Quantidade: "+getQuantidade()+"\n"+
		"Desscri��o: "+getDescri��o();
}
	
	
	public Produto(int codigo, double pre�o, int quantidade, String descri��o) {
		super();
		this.codigo = codigo;
		this.pre�o = pre�o;
		this.quantidade = quantidade;
		this.descri��o = descri��o;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPre�o() {
		return pre�o;
	}
	public void setPre�o(double pre�o) {
		this.pre�o = pre�o;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescri��o() {
		return descri��o;
	}
	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
	}
}
