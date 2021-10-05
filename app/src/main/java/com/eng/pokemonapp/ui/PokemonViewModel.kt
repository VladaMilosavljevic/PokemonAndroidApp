package com.eng.pokemonapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eng.pokemonapp.db.PokemonDatabase
import com.eng.pokemonapp.model.Pokemon
import com.eng.pokemonapp.model.PokemonListResponse
import com.eng.pokemonapp.model.PokemonResults
import com.eng.pokemonapp.repository.Repository
import kotlinx.coroutines.launch

class PokemonViewModel(private val repository: Repository) : ViewModel() {


    var myResponseList: MutableLiveData<PokemonListResponse> = MutableLiveData()
    var myResponseDetails: MutableLiveData<Pokemon> = MutableLiveData()





    fun getPokemons() {
        viewModelScope.launch {
            val response = repository.getPokemons()
            myResponseList.value = response
        }
    }
    fun getPokemonByName(name: String): Pokemon? {
        viewModelScope.launch {
            val response = repository.getPokemonByName(name)
            myResponseDetails.value = response

        }
        return myResponseDetails.value
    }



}