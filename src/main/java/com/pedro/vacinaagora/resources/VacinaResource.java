package com.pedro.vacinaagora.resources;

import java.net.URI;

import com.pedro.vacinaagora.entities.Vacina;
import com.pedro.vacinaagora.services.VacinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class VacinaResource {
    
    @Autowired
    private VacinaService service;

    @PostMapping(value = "vacina")
    public ResponseEntity<Void> insert(@RequestBody Vacina obj) {
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "vacina/{id}")
    public ResponseEntity<Vacina> find(@PathVariable Long id) {
        Vacina obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
