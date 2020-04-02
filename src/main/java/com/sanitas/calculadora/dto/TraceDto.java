package com.sanitas.calculadora.dto;

import lombok.Data;

@Data
public class TraceDto {

	private String operador;
	private Integer[] parametros;

	public TraceDto(String operador, Integer... parametros) {
		this.operador = operador;
		this.parametros = parametros;
	}

	public String trace() {
		String mensaje = "No existe la operación";

		switch (this.operador) {
		case "suma":
			mensaje = String.format("La operación es SUMAR: (%s + %s) = %s", this.parametros[0], this.parametros[1],
					this.parametros[2]);
			break;
		case "restar":
			mensaje = String.format("La operación es RESTAR: (%s - %s) = %s", this.parametros[0], this.parametros[1],
					this.parametros[2]);
			break;

		}
		return mensaje;
	}
}
