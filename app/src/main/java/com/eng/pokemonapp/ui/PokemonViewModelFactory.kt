package com.eng.pokemonapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eng.pokemonapp.repository.Repository

class PokemonViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PokemonViewModel(repository) as T
    }
}