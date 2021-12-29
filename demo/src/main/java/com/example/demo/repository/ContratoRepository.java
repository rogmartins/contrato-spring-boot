package com.example.demo.repository;

import com.example.demo.model.Contrato;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContratoRepository extends CrudRepository<Contrato, Long>{
    
}
