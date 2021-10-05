package com.eng.pokemonapp.api


import com.eng.pokemonapp.model.PokemonListResponse
import com.eng.pokemonapp.model.Pokemon

import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon?limit=20")
    suspend fun  getPokemons(): PokemonListResponse

    @GET("pokemon/{name}")
    suspend   fun getPokemonByName(@Path("name") name: String): Pokemon
}