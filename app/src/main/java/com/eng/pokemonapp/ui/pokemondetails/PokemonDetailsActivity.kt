package com.eng.pokemonapp.ui.pokemondetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.eng.pokemonapp.ui.PokemonViewModelFactory
import com.eng.pokemonapp.R
import com.eng.pokemonapp.repository.Repository
import com.eng.pokemonapp.ui.PokemonViewModel
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import kotlinx.android.synthetic.main.activity_pokemon_details.pokemonName
import org.koin.android.ext.android.inject

class PokemonDetailsActivity : AppCompatActivity() {

    lateinit var viewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val viewModelFactory: PokemonViewModelFactory by inject()

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(PokemonViewModel::class.java)

        initializeUI()
    }

    fun initializeUI() {
        val name = intent.getStringExtra("name")

        if (name != null) {
            viewModel.getPokemonByName(name)
        }
        viewModel.myResponseDetails.observe(this, Observer { pokemon ->
            pokemonName.text = pokemon.name

            val pokemonH = pokemon.height / 10.0
            val pokemonW = pokemon.weight / 10.0

            pokemonHeight.text = "Height:" + pokemonH.toString() + "m"
            pokemonWeight.text = "Weight:" + pokemonW.toString() + "kg"
            for (p in pokemon.type) {
                pokemonType.text = "Type:" + p.types.name
            }
            for (stat in pokemon.stats) {
                pokemonBaseStat.text = "Base stat:" + stat.base_stat
                pokemonEffort.text = "Effort:" + stat.effort
            }
            Glide.with(this).load(pokemon.sprites.frontDefault).diskCacheStrategy(DiskCacheStrategy.DATA).into(imageViewFront)
            Glide.with(this).load(pokemon.sprites.backDefault).diskCacheStrategy(DiskCacheStrategy.DATA).into(imageViewBack)

        })
    }
}