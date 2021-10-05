package com.eng.pokemonapp.ui.pokemonlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eng.pokemonapp.ui.PokemonViewModelFactory
import com.eng.pokemonapp.R
import com.eng.pokemonapp.ui.PokemonListAdapter
import com.eng.pokemonapp.ui.PokemonViewModel
import org.koin.android.ext.android.inject


var listAdapter: PokemonListAdapter? = null

class PokemonListActivity : AppCompatActivity() {
    private lateinit var viewModel: PokemonViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)


        val viewModelFactory :PokemonViewModelFactory by inject ()

        viewModel = ViewModelProvider(this, viewModelFactory).get(PokemonViewModel::class.java)

        initializeUI()
    }

    private fun initializeUI() {

        viewModel.getPokemons()

        viewModel.myResponseList.observe(this, Observer { response ->

            listAdapter = PokemonListAdapter(response.results)
            val recyclerView = findViewById<RecyclerView>(R.id.pokemonListRecyclerView)
            recyclerView.adapter = listAdapter
            recyclerView.setLayoutManager(GridLayoutManager(this, 2))
            println("data  results pokemon " + response.results.toString())
        })




    }
}