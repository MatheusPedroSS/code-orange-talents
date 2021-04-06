package com.pedro.vacinaagora.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.pedro.vacinaagora.entities.Vacina;
import com.pedro.vacinaagora.repositories.VacinaRepository;
import com.pedro.vacinaagora.services.exceptions.DataIntegrityException;
import com.pedro.vacinaagora.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {
    
    @Autowired
    private VacinaRepository repo;

    @Autowired
    private PessoaService pessoaService;

    public Vacina find(Long id) {
        Optional<Vacina> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Vácina de id: " + id + " não encontrada."));
    }

    public Vacina insert(Vacina obj) {
        obj.setPessoa(pessoaService.find(obj.getPessoa().getId()));
        pessoaService.find(obj.getPessoa().getId()).setVacinas(Arrays.asList(obj));
        obj.setId(null);
        return repo.save(obj);
    }

    public Vacina update(Vacina obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Long id) {
        find(id);
        try{
            repo.deleteById(id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não e possivel excluir uma Vácina que já tenha sido aplicado em alguma Pessoa.");
        }
    }

    public List<Vacina> findAll() {
        return repo.findAll();
    }
}
