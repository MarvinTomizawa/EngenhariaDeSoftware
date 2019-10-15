package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)               // Cria tabelas utilizando join e o mesmo Id
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)       // Junta tudo as colunas e adiciona uma coluna com o tipo do registro
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)    // Cria varias tabelas com informações repetidas

public class Pessoa {
    @Id
    @Getter
    @Setter
    private UUID id = UUID.randomUUID();

    @Column(name = "nome")
    @Getter
    @Setter
    private String nome;
}
