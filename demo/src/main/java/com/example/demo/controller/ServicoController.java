package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.model.Servico;
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
public class ServicoController {
   
    // Injecao de dependencia
    @Autowired
    private ServicoRepository servicoRepository;

    /**
     * Exibir listagem de serviços
     */

    @GetMapping("/servicos/listar")
    public ModelAndView listar() {
        Iterable<Servico> servicos = servicoRepository.findAll();

        ModelAndView mv = new ModelAndView("servicos/listar");
        mv.addObject("servicos", servicos);

        return mv;
    }

    /**
     * Editar registro de um serviço
     * 
     * */

    @GetMapping("/servicos/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("servicos/editar");
        
        // Buscar o registro a ser editado
        Optional<Servico> servico = servicoRepository.findById(id);
        
        // Enviar para a view a ser retornada
        mv.addObject("servico", servico);
        
        return mv;
    }

    /**
     * Incluir registro de uma pessoa
     */

    @GetMapping("/servicos/incluir")
    public ModelAndView incluir() {
        ModelAndView mv = new ModelAndView("servicos/incluir");
        
        // Cria um Bean "vazio"
        Servico servico = new Servico();
        
        // Enviar para a view a ser retornada
        mv.addObject("servico", servico);
        
        return mv;
    }

    /**
     * Salva um registro (insere ou atualiza)
     */

    @RequestMapping(value = "/salvarServico", method = RequestMethod.POST)
    public ModelAndView salvar(@ModelAttribute Servico servico, BindingResult errors, Model model) {

        servicoRepository.save(servico);

        // Listar os registros após salvar
        Iterable<Servico> servicos = servicoRepository.findAll();
        ModelAndView mv = new ModelAndView("redirect:/servicos/listar");
        mv.addObject("servicos", servicos);

        return mv;
    }


    /**
     * Excluir registro de um serviço
     */

    @GetMapping("/servicos/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
       
        servicoRepository.deleteById(id);
        Iterable<Servico> servicos = servicoRepository.findAll();

        ModelAndView mv = new ModelAndView("servicos/listar");
        mv.addObject("servicos", servicos);
        return mv;
    }

}
