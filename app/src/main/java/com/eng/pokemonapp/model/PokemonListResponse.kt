package com.eng.pokemonapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pokemons")
data class PokemonListResponse(
    @PrimaryKey val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonResults> = arrayListOf()
)


