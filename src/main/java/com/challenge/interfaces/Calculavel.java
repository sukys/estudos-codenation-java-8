package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {

	/**
	 * O método somar: deverá somar todos os atributos do tipo BigDecimal de uma
	 * classe recebida como parâmetro e retornar um BigDecimal.
	 * 
	 * @param classe
	 * @return
	 */
	BigDecimal somar(Object classe);

	/**
	 * O método subtrair: deverá somar todos os atributos do tipo BigDecimal de uma
	 * classe recebida como parâmetro e retornar um BigDecimal..
	 * 
	 * @param classe
	 * @return
	 */
	BigDecimal subtrair(Object classe);

	/**
	 * O método total: deverá subtrair os atributos annotados com "Subtrair" dos
	 * atributos annotados com "Somar".
	 * 
	 * @param classe
	 * @return
	 */
	BigDecimal totalizar(Object classe);

}
