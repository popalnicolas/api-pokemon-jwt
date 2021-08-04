package com.example.apipokemonsecure.Webservices.Services;

import com.example.apipokemonsecure.Model.Pokemon;
import com.example.apipokemonsecure.Repository.IPokemonRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    private final IPokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> getAllPokemons() {
        log.info("Getting all pokemons from the database");
        return pokemonRepository.findAll();
    }

    @Override
    public List<Pokemon> getPokemonsById(int id) {
        log.info("Getting pokemon with id {} from the database", id);
        return pokemonRepository.getAllByPokemonId(id);
    }

    @Override
    public List<Pokemon> getPokemonsByType(int type) {
        log.info("Getting all pokemons of type {} from the database", type);
        return pokemonRepository.getAllByPokemonType(type);
    }

    @Override
    public Pokemon savePokemon(Pokemon pokemon) {
        log.info("Saving new pokemon {} to the database", pokemon.getPokemonName());
        pokemon.setPokemonLikes(0);
        pokemon.setPokemonId(0);
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon likePokemon(Pokemon pokemon) {
        log.info("Liking pokemon with pokemon id {}", pokemon.getPokemonName());
        pokemon.setPokemonLikes(pokemon.getPokemonLikes()+1);
        return pokemonRepository.save(pokemon);
    }

    @Override
    public void removePokemon(int id) {
        log.info("Removing pokemon with id {} from the database", id);
        pokemonRepository.deleteById(id);
    }
}
