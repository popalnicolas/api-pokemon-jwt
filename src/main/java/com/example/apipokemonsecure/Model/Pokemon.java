package com.example.apipokemonsecure.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pokemon", schema = "dbo")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokemonId")
    private int pokemonId;

    @Column(name = "pokemonName")
    private String pokemonName;

    @Column(name = "pokemonType")
    private int pokemonType;

    @Column(name = "pokemonImage")
    private String pokemonImage;

    @Column(name = "pokemonDescription")
    private String pokemonDescription;

    @Column(name = "pokemonLikes")
    private int pokemonLikes;
}
