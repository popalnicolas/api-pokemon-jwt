package com.example.apipokemonsecure.Webservices.Api;

import com.example.apipokemonsecure.Model.Pokemon;
import com.example.apipokemonsecure.Webservices.Services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Pokemon>> getAllPokemons(@RequestParam Optional<Integer> id, @RequestParam Optional<Integer> type)
    {
        List<Pokemon> pokemons;
        if(id.isPresent())
            pokemons = pokemonService.getPokemonsById(id.get());
        else if (type.isPresent())
            pokemons = pokemonService.getPokemonsByType(type.get());
        else
            pokemons = pokemonService.getAllPokemons();

        if(!pokemons.isEmpty())
            return ResponseEntity.ok(pokemons);

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/like")
    @ResponseBody
    public ResponseEntity<Pokemon> likePokemon(@RequestBody Pokemon pokemon)
    {
        return ResponseEntity.ok().body(pokemonService.likePokemon(pokemon));
    }

    @PostMapping
    public ResponseEntity<Pokemon> savePokemon(@RequestBody Pokemon pokemon)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
        return ResponseEntity.created(uri).body(pokemonService.savePokemon(pokemon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removePokemon(@PathVariable("id") int id)
    {
        pokemonService.removePokemon(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
