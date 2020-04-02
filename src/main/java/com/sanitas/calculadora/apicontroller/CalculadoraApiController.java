package com.sanitas.calculadora.apicontroller;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculadora.dto.TraceDto;
import com.sanitas.calculadora.service.CalculadoraService;

import io.corp.calculator.TracerImpl;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraApiController {

	private CalculadoraService calculadoraService;
	private TraceDto traceDto;
	private TracerImpl tracerImpl;

	public CalculadoraApiController(CalculadoraService calculadoraService) {
		super();
		this.calculadoraService = calculadoraService;
		this.tracerImpl = new TracerImpl();
	}

	@GetMapping
	public String getStatus() {
		return "Online";
	}

	@GetMapping("/sumar")
	public ResponseEntity<Integer> sumar(@PathParam("") Integer numero1, @PathParam("") Integer numero2) {
		int resultado = this.calculadoraService.sumar(numero1, numero2);
		this.traceDto = new TraceDto("suma", numero1, numero2, resultado);
		this.tracerImpl.trace(this.traceDto.trace());
		return ResponseEntity.ok(resultado);
	}

	@GetMapping("/restar")
	public ResponseEntity<Integer> restar(@PathParam("") Integer numero1, @PathParam("") Integer numero2) {
		int resultado = this.calculadoraService.restar(numero1, numero2);
		this.traceDto = new TraceDto("restar", numero1, numero2, resultado);
		this.tracerImpl.trace(this.traceDto.trace());
		return ResponseEntity.ok(resultado);
	}
}
