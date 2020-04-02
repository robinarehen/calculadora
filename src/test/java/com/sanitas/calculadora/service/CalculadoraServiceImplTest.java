package com.sanitas.calculadora.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculadoraServiceImplTest {

	@Autowired
	private CalculadoraServiceImpl calculadoraService;

	@Test
	public void sumar() {

		int numero1 = 2;
		int numero2 = 3;

		int resultado = this.calculadoraService.sumar(numero1, numero2);

		int expected = numero1 + numero2;

		assertThat(expected).isEqualTo(resultado);
	}
	
	@Test
	public void restar() {
		
		int numero1 = 3;
		int numero2 = 2;

		int resultado = this.calculadoraService.restar(numero1, numero2);

		int expected = numero1 + numero2;

		assertThat(expected).isEqualTo(resultado);
	}
}
