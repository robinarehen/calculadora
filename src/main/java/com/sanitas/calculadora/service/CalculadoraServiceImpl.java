package com.sanitas.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	@Override
	public int sumar(int numero1, int numero2) {
		// TODO Auto-generated method stub
		return (numero1 + numero2);
	}

	@Override
	public int restar(int numero1, int numero2) {
		// TODO Auto-generated method stub
		return (numero1 - numero2);
	}

}
