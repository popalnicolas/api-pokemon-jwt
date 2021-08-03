package com.example.apipokemonsecure.Repository;

import com.example.apipokemonsecure.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPokemonRepository extends JpaRepository<Pokemon, Integer> {
    List<Pokemon> getAllByPokemonId(int id);
    List<Pokemon> getAllByPokemonType(int type);
}
