package com.sanitas.calculadora.apicontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculadoraApiControllerTest {

	@Autowired
	private MockMvc mockMvc;
	private MvcResult mvcResult;
	
	private Integer numero1;
	private Integer numero2;

	@BeforeEach
	public void init() {
		this.numero1 = 3;
		this.numero2 = 2;
	}
	
	@Test
	public void suma() throws Exception {
		String url = "/calculadora/sumar";
		
		this.mvcResult = this.mockMvc.perform(
					get(url)
					.contentType(MediaType.APPLICATION_JSON)
					.param("numero1", this.numero1.toString())
					.param("numero2", this.numero2.toString())
				).andReturn();
		
		Integer statusExpected = 200;
		Integer statusActual = this.mvcResult.getResponse().getStatus();
		
		assertThat(statusActual).isEqualTo(statusExpected);
		
		Integer resultExpected = this.numero1 + this.numero2;
		String resultActual = this.mvcResult.getResponse().getContentAsString();

		assertThat(resultActual).isEqualTo(resultExpected.toString());
	}
}
