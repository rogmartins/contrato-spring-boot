package com.example.demo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.example.demo.model.Contrato;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Servico;
import com.example.demo.repository.ContratoRepository;
import com.example.demo.repository.PessoaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PessoaRepository pessoaRepository; 

	@Autowired
	private ContratoRepository contratoRepository;

	@Test
	void testNewPessoa() {
	 /*
		Pessoa p = new Pessoa();
	  p.setCpfCnpj("102.306.270-45");
	  p.setTipo("FISICA");
	  p.setNome("Joao");
	  p.setSobrenome("Silva");
	  pessoaRepository.save(p);
	  System.out.println("Salvou");*/
	}
	
	//@Test
	void testNewContrato() {
		Calendar calendar1 = new GregorianCalendar(2021,1,10);
		Calendar calendar2 = new GregorianCalendar(2021,3,10);

		Contrato c = new Contrato();

		c.setDtInicio(calendar1.getTime());
		c.setDtFim(calendar2.getTime());
		BigDecimal valor = new BigDecimal(450);
		c.setValorContratado(valor);

		Pessoa contratante = new Pessoa();
		contratante.setId(1L);

		Pessoa contratada = new Pessoa();
		contratada.setId(2L);

		c.setContratante(contratante);
		c.setContratante(contratada);

		Servico servico = new Servico();
		servico.setId(5L);

		c.setServico(servico);

		contratoRepository.save(c);
	}

}
