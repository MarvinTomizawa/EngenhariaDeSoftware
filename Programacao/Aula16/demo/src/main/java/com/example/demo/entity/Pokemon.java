package com.example.demo.entity;

import com.example.demo.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Pokemon extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "nome")
    private String nome;

    @Getter
    @Setter
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private ETipo tipo;

}
