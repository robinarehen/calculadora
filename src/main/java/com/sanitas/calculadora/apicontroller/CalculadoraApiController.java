package com.sanitas.calculadora.apicontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CalculadoraApiController {

	@GetMapping
	public String getStatus() {
		return "Online";
	}
}
