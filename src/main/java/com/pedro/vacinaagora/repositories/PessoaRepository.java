package com.pedro.vacinaagora.repositories;

import com.pedro.vacinaagora.entities.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
