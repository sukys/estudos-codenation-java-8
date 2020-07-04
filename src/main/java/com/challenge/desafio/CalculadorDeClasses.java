package com.challenge.desafio;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

	/**
	 * O método somar: deverá somar todos os atributos do tipo BigDecimal de uma
	 * classe recebida como parâmetro e retornar um BigDecimal.
	 * 
	 * @param classe
	 * @return
	 */
	@Override
	public BigDecimal somar(Object classe) {
		BigDecimal total = BigDecimal.ZERO;
		for (Field field : classe.getClass().getDeclaredFields()) {
			if (isSomar(field))
				total = total.add(getValueFromField(field, classe));
		}
		return total;
	}

	/**
	 * O método subtrair: deverá somar todos os atributos do tipo BigDecimal de uma
	 * classe recebida como parâmetro e retornar um BigDecimal..
	 * 
	 * @param classe
	 * @return
	 */
	@Override
	public BigDecimal subtrair(Object classe) {
		BigDecimal total = BigDecimal.ZERO;
		for (Field field : classe.getClass().getDeclaredFields()) {
			if (isSubtrair(field))
				total = total.add(getValueFromField(field, classe));
		}
		return total;
	}

	/**
	 * O método total: deverá subtrair os atributos annotados com "Subtrair" dos
	 * atributos annotados com "Somar".
	 * 
	 * @param classe
	 * @return
	 */
	@Override
	public BigDecimal totalizar(Object classe) {
		return somar(classe).subtract(subtrair(classe));
	}

	/**
	 * Recupera o valor do campo informado se for BigDecimal Caso o atributo não
	 * seja BigDecimal, retorna BigDecimal.ZERO
	 * 
	 * @param field
	 * @param classe
	 * @return
	 */
	private BigDecimal getValueFromField(Field field, Object classe) {
		field.setAccessible(true);
		if (isBigDecimal(field)) {
			try {
				return (BigDecimal) field.get(classe);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return BigDecimal.ZERO;
	}

	/**
	 * Verifica se um campo é do tipo BigDecimal.
	 * 
	 * @param field
	 * @return
	 */
	private boolean isBigDecimal(Field field) {
		return field.getType().isAssignableFrom(BigDecimal.class);
	}

	/**
	 * Verifica se o campo tem a anotação de somar
	 * 
	 * @param field
	 * @return
	 */
	private boolean isSomar(Field field) {
		return field.isAnnotationPresent(Somar.class);
	}

	/**
	 * Verifica se o campo possui a anotação para subtrair.
	 * 
	 * @param field
	 * @return
	 */
	private boolean isSubtrair(Field field) {
		return field.isAnnotationPresent(Subtrair.class);
	}

}
