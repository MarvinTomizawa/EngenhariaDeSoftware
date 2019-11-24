package com.example.demo.controller;

import com.example.demo.base.BaseController;
import com.example.demo.entity.ETipo;
import com.example.demo.entity.Pokemon;
import com.example.demo.repository.PokePc;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController extends BaseController<Pokemon, PokePc> {

    @GetMapping("/type/{typeId}")
    public Pokemon findByType(@PathVariable("typeId") int typeId){
        return repository.findByTipo(ETipo.of(typeId))
                .orElseThrow(() -> new RuntimeException("Num achei"));
    }
}
