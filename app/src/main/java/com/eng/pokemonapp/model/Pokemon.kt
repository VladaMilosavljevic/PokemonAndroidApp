package com.eng.pokemonapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "pokemon")
data class Pokemon(

    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") @SerializedName("id") val id: Int = 0,
    @ColumnInfo(name = "name") @SerializedName("name") var name: String = "",
    @ColumnInfo(name = "weight") @SerializedName("weight") var weight: Double = 0.0,
    @ColumnInfo(name = "height") @SerializedName("height") var height: Double = 0.0,
    @ColumnInfo(name = "sprites") @SerializedName("sprites") val sprites: Sprites = Sprites(),
    @ColumnInfo(name = "types") @SerializedName("types") val type: List<Type> = arrayListOf(),
    @ColumnInfo(name = "stats") @SerializedName("stats") val stats: List<StatObject> = arrayListOf(),

    )

data class StatObject(
    val base_stat: String = "",
    val effort: Int = 0,
)


data class Sprites(
    @SerializedName("front_default") val frontDefault: String = "",
    @SerializedName("back_default") val backDefault: String = "",
    @SerializedName("other") val other: Other = Other()

)

data class Other(
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork = OfficialArtwork()
)

data class OfficialArtwork (
    @SerializedName("front_default")
    val frontDefaultOffArtwork: String = ""
)

data class Type(
    val slot: String = "",
    @SerializedName("type") val types: Types = Types()
)

data class Types(
    val name: String = "",
    val url: String = ""
)