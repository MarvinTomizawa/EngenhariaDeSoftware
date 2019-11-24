package com.example.demo.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class BaseController<ENTITY extends  BaseEntity, REPOSITORY extends JpaRepository<ENTITY, UUID>>{

    @Autowired
    protected REPOSITORY repository;

    @GetMapping
    public List<ENTITY> get(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public List<ENTITY> getById(@PathVariable("id") UUID uuid){
        return repository.findAll();
    }

    @PostMapping
    public UUID post(@RequestBody ENTITY object){
        repository.save(object);
        return object.getId();
    }

    @PutMapping("/{id}")
    public UUID put(@RequestBody ENTITY object, @PathVariable("id") UUID uuid){
        ENTITY searched = repository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Entidade não encontrada!"));


        repository.save(object);

        return object.getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID uuid){
        repository.deleteById(uuid);
    }

}
