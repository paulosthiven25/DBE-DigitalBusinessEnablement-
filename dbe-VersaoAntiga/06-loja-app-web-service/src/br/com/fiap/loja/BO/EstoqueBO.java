package br.com.fiap.loja.BO;



import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;

import br.com.fiap.loja.TO.Produto;


public class EstoqueBO {

	private static Logger log = Logger.getLogger(EstoqueBO.class); 
	public Produto consultarProduto(int codigo) throws AxisFault {
		log.debug("Loja erro");
		Produto produto;
		switch(codigo) {
		case 401:
			produto=new Produto(401,10,5,"Camiseta branco");
			break;
			
		case 402:
			produto=new Produto(402,130,10,"Camiseta ouro");
			break;
			
		case 403:
			produto=new Produto(403,35,435,"Camiseta preta");
			break;
			
		case 0 :
			System.out.println("Fechando o programa");
			
			default:throw new AxisFault("Produto não encontrado");
			
		}
		
		return produto;
	}
		
	
}
