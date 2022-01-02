package com.example.demo.controller;

import com.example.demo.model.Contrato;
import com.example.demo.repository.ContratoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContratoController {
   
    // Injecao de dependencia
	@Autowired
	private ContratoRepository contratoRepository; 

    /**
     * Exibir listagem de contratos
     */
    
    @GetMapping(value="/contratos/listar")
    public ModelAndView listar() {
        Iterable<Contrato> contratos = contratoRepository.findAll();
        ModelAndView mv = new ModelAndView("contratos/listar");
        mv.addObject("contratos", contratos);
        return mv;
    }

}
