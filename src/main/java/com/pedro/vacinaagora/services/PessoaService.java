package com.pedro.vacinaagora.services;

import java.util.List;
import java.util.Optional;

import com.pedro.vacinaagora.entities.Pessoa;
import com.pedro.vacinaagora.repositories.PessoaRepository;
import com.pedro.vacinaagora.services.exceptions.DataIntegrityException;
import com.pedro.vacinaagora.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

public class PessoaService {
    
    @Autowired
    private PessoaRepository repo;


    public Pessoa find(Long id) {
        Optional<Pessoa> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pessoa de id: " + id + " não encontrada."));
    }

    public Pessoa insert(Pessoa obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Pessoa update(Pessoa obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Long id) {
        find(id);
        try{
            repo.deleteById(id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não e possivel excluir uma Pessoa que já tenha tomando vácina.");
        }
    }

    public List<Pessoa> findAll() {
        return repo.findAll();
    }
}
