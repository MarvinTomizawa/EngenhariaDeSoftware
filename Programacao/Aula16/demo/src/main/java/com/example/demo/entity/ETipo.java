package com.example.demo.entity;

import java.util.stream.Stream;

public enum ETipo {
    FOGO(1),
    AGUA(2),
    GRAMA(3),
    VOADOR(4);

    ETipo(int tipo) {
        this.tipo = tipo;
    }

    private int tipo;

    public static ETipo of(int tipoId){
        return Stream.of(values())
                .filter(pokemon -> pokemon.tipo == tipoId)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));
    }
}
