package com.pedro.vacinaagora.repositories;

import com.pedro.vacinaagora.entities.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
