package com.example.demo.repository;

import com.example.demo.model.Servico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ServicoRepository  extends CrudRepository<Servico, Long> {
    
}
