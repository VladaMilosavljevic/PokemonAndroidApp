package com.eng.pokemonapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class PokemonResults(
    val name:String,
    val url:String
)