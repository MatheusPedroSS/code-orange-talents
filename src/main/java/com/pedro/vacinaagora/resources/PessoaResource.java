package com.pedro.vacinaagora.resources;

import java.net.URI;

import com.pedro.vacinaagora.entities.Pessoa;
import com.pedro.vacinaagora.services.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PessoaResource {
    
    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Pessoa obj) {
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Pessoa> find(@PathVariable Long id) {
        Pessoa obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
