package com.eng.pokemonapp.utils

import androidx.room.TypeConverter
import com.eng.pokemonapp.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {



    @TypeConverter
    fun listToJson(value: List<PokemonResults>?) = Gson().toJson(value)


    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<PokemonResults>::class.java).toList()
    }

