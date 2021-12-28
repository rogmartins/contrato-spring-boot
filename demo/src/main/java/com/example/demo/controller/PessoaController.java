package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PessoaController {

	// Injecao de dependencia
	@Autowired
	private PessoaRepository pessoaRepository; 

    /**
     * Exibir listagem de pessoas
     */

    @GetMapping("/pessoas/listar")
    public ModelAndView listar() {
        Iterable<Pessoa> pessoas = pessoaRepository.findAll();

        ModelAndView mv = new ModelAndView("pessoas/listar");
        mv.addObject("pessoas", pessoas);

        return mv;
    }

    /**
     * Editar registro de uma pessoa
     */

    @GetMapping("/pessoas/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("pessoas/editar");
        
        // Buscar o registro a ser editado
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        
        // Enviar para a view a ser retornada
        mv.addObject("pessoa", pessoa);
        
        return mv;
    }
    /**
     * Incluir registro de uma pessoa
     */

    @GetMapping("/pessoas/incluir")
    public ModelAndView incluir() {
        ModelAndView mv = new ModelAndView("pessoas/incluir");
        
        // Cria um Bean "vazio"
        Pessoa pessoa = new Pessoa();
        
        // Enviar para a view a ser retornada
        mv.addObject("pessoa", pessoa);
        
        return mv;
    }

    @RequestMapping(value = "/salvarPessoa", method = RequestMethod.POST)
    public ModelAndView salvar(@ModelAttribute Pessoa pessoa, BindingResult errors, Model model) {

        pessoaRepository.save(pessoa);

        // Listar os registros após salvar
        Iterable<Pessoa> pessoas = pessoaRepository.findAll();

        ModelAndView mv = new ModelAndView("redirect:/pessoas/listar");
        mv.addObject("pessoas", pessoas);

        return mv;
        
    }

    /**
     * Excluir registro de uma pessoa
     */

    @GetMapping("/pessoas/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("pessoas/listar");
        return mv;
    }

    /**
     * Pesquisar registro de uma pessoa
     * @param expressao
     * @return ModelAndView
     */
   
    @PostMapping("/pessoas/pesquisar")
    public ModelAndView pesquisar(@RequestParam("expressao") String expressao) {
        ModelAndView mv = new ModelAndView("pessoas/listar");
        return mv;
    }

}
