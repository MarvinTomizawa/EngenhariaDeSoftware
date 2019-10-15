package com.example.demo.controller;

import com.example.demo.entity.Pessoa;
import com.example.demo.entity.PessoaFisica;
import com.example.demo.entity.PessoaJuridica;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> getAllPessoas(){
        return pessoaRepository.findAll();
    }

    @GetMapping
    public List<Pessoa> getAllPessoasJuridicas(){
        return pessoaRepository.findAll();
    }

    @PostMapping
    public String postFisica(@RequestBody()PessoaFisica pessoaFisica){
        return save(pessoaFisica);
    }

    @PostMapping
    public String postJuridica(@RequestBody()PessoaJuridica pessoaJuridica){
        return save(pessoaJuridica);
    }

    private String save(Pessoa pessoa){
        return pessoaRepository.save(pessoa).getId().toString();
    }

}
