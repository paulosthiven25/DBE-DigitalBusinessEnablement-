package br.com.fiap.revisao.bean;

public class Pessoa {
	
	/* Modificadoores de acesso
	 * public,private
	 * protected - filhas e pacotes
	 * default/package - pacote
	 */
	
	private String nome;
	private Genero genero;
	private int rm;

	
	public Pessoa(String nome) {
		super();
		setNome(nome);
	}
	
	//REGRA DE CONSTRUTOR
		//1-MESMO NOME DA CLASSE,2-NÃO TEM RETORNO(NEM VOID),3-CHAMAR UM CONSTRUTOR VAZIO DO PAI
	public Pessoa() {
			super();
		}
	
	public boolean validarRm() {
		String rmstr=String.valueOf(rm);
		if(rmstr.length()==5) {
			return true;
		}else {
			return false;
		}
	}
		

		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome=nome;
		}
		
		public int getRm() {
			return rm;
		}
		public void setRm(int rm) {
			this.rm = rm;
		}

		public Genero getGenero() {
			return genero;
		}

		public void setGenero(Genero genero) {
			this.genero = genero;
		}
}
