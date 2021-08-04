package com.example.apipokemonsecure.Webservices.Services;

import com.example.apipokemonsecure.Model.Pokemon;

import java.util.List;

public interface PokemonService {
    List<Pokemon> getAllPokemons();
    List<Pokemon> getPokemonsById(int id);
    List<Pokemon> getPokemonsByType(int type);
    Pokemon savePokemon(Pokemon pokemon);
    Pokemon likePokemon(Pokemon pokemon);
    void removePokemon(int id);
}
