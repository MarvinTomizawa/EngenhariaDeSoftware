package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PessoaJuridica extends Pessoa {
    @Getter
    @Setter
    private String razaoSocial;

    @Getter
    @Setter
    private LocalDate fundadaEm;
}
