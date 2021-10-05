package com.eng.pokemonapp.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.eng.pokemonapp.api.RetrofitInstance
import com.eng.pokemonapp.db.PokemonDatabase
import com.eng.pokemonapp.model.PokemonListResponse
import com.eng.pokemonapp.model.Pokemon


class Repository  (private val app: Application) : AndroidViewModel(app)  {

    suspend fun getPokemons(): PokemonListResponse {
        return RetrofitInstance.api.getPokemons()
    }
    suspend fun getPokemonByName(name: String): Pokemon {
        return RetrofitInstance.api.getPokemonByName(name)
    }




}