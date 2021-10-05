package com.eng.pokemonapp

import com.eng.pokemonapp.repository.Repository
import com.eng.pokemonapp.ui.PokemonViewModel
import com.eng.pokemonapp.ui.PokemonViewModelFactory
import org.koin.dsl.module.module

val appModule = module {


    single { Repository(get()) }

    factory { PokemonViewModelFactory(get()) }
}