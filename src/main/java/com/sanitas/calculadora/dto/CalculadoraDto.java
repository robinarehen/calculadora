package com.sanitas.calculadora.dto;

import com.sanitas.calculadora.util.Operadores;

import lombok.Data;

@Data
public class CalculadoraDto {
	
	private String operador;
	private Integer num1;
	private Integer num2;
	
	public void validOperator() {
		try {
			Operadores.valueOf(operador);
		}catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException("Operador no valido");
		}
	}

}
