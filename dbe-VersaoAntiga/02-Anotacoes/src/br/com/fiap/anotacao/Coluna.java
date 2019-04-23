package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//ONDE � POSS�VEL COLOCAR A ANOTA��O
@Target(ElementType.FIELD)	
public @interface Coluna {
	
	String nome();
	boolean obrigatorio();
}
