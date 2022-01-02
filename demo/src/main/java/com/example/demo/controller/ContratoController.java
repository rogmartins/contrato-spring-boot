package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.model.Contrato;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Servico;
import com.example.demo.repository.ContratoRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.ServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContratoController {
   
    // Injecao de dependencia
	@Autowired
	private ContratoRepository contratoRepository; 

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ServicoRepository servicoRepository;
    
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

    /**
     * Editar registro de um contrato
     */
    @GetMapping("/contratos/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("contratos/editar");
        
        // Contratante / Contratada
        Iterable<Pessoa> pessoas = pessoaRepository.findAll();
        
        // Opções de Servicos
        Iterable<Servico> servicos = servicoRepository.findAll();
        
        // Buscar o registro a ser editado
        Optional<Contrato> contrato = contratoRepository.findById(id);
        

        // Enviar para a view a ser retornada
        mv.addObject("contrato", contrato);
        mv.addObject("pessoas", pessoas);
        mv.addObject("servicos", servicos);
        return mv;
    }

    /**
     * Salva um registro (insere ou atualiza)
     */

    @RequestMapping(value = "/salvarContrato", method = RequestMethod.POST)
    public ModelAndView salvar(@ModelAttribute Contrato contrato, BindingResult errors, Model model) {

        contratoRepository.save(contrato);

        // Listar os registros após salvar
        Iterable<Contrato> contratos = contratoRepository.findAll();

        ModelAndView mv = new ModelAndView("redirect:/contratos/listar");
        mv.addObject("contratos", contratos);

        return mv;
        
    }


}
