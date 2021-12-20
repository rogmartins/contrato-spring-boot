package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Pessoa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	@Query("select p from Pessoa p where p.nome like %?1% ")
	List<Pessoa> findPessoaByName(String nome);
}