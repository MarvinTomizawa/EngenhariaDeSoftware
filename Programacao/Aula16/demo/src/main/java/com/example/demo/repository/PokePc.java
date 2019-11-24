package com.example.demo.repository;

import com.example.demo.base.BaseRepository;
import com.example.demo.entity.ETipo;
import com.example.demo.entity.Pokemon;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokePc extends BaseRepository<Pokemon> {
    Optional<Pokemon> findByTipo(ETipo tipo);
}
