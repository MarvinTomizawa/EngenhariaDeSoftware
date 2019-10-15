package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PessoaFisica extends Pessoa {
    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private LocalDate dataNascimento;
}
