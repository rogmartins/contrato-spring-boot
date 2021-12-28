package com.example.demo.controller;

import com.example.demo.repository.ServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ServicoController {
   
    // Injecao de dependencia
    @Autowired
    private ServicoRepository servicoRepository;
}
