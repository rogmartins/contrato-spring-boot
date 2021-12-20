package com.example.demo;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PessoaRepository pessoaRepository; 


	@Test
	void testNewPessoa() {
	  Pessoa p = new Pessoa();
	  p.setCpfCnpj("102.306.270-45");
	  p.setTipo("FISICA");
	  p.setNome("Joao");
	  p.setSobrenome("Silva");
	  pessoaRepository.save(p);
	  System.out.println("Salvou");
	}

}
