package com.eng.pokemonapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.eng.pokemonapp.R
import com.eng.pokemonapp.model.PokemonResults
import com.eng.pokemonapp.ui.pokemondetails.PokemonDetailsActivity
import kotlinx.android.synthetic.main.pokemon_list_cell.view.*

var rowIndex: Int? = null

class PokemonListAdapter(var data: List<PokemonResults>) :
    RecyclerView.Adapter<CustomViewHolder>() {
    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.pokemon_list_cell, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.pokemonName.text = data[position].name

        //image into main page
        // taking number id from url
        val number = if (data[position].url.endsWith("/")) {
            data[position].url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            data[position].url.takeLastWhile { it.isDigit() }
        }
        val imageUrl =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${number}.png"
        Glide.with(holder.itemView.context).load(imageUrl).diskCacheStrategy(DiskCacheStrategy.DATA).into(holder.view.imageMain);

        //sending data to details activity
        holder.itemView.layoutPokemonList.setOnClickListener { view ->
            rowIndex = position
            val intent = Intent(view.context, PokemonDetailsActivity::class.java)
            intent.putExtra("name", data[position].name)
            view.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.count()
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
}