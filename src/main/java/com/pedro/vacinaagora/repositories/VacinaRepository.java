package com.pedro.vacinaagora.repositories;

import com.pedro.vacinaagora.entities.Vacina;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    
}
