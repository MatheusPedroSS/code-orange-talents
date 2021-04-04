package com.pedro.vacinaagora.repositories;

import com.pedro.vacinaagora.entities.Vacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    
}
