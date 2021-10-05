package com.eng.pokemonapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.eng.pokemonapp.model.PokemonListResponse
import com.eng.pokemonapp.model.PokemonResults


@Dao
interface PokemonDao {


    @Query("SELECT * FROM pokemons")
    fun getPokemons(): List<PokemonListResponse>

    @Query("SELECT * FROM pokemons")
    fun getPokemonsInDatabase(): List<PokemonListResponse>

}