package com.eng.pokemonapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.eng.pokemonapp.model.PokemonListResponse
import com.eng.pokemonapp.model.PokemonResults
import com.eng.pokemonapp.utils.Converter

@Database(entities = [PokemonListResponse::class], version = 1)
@TypeConverters(Converter::class)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao

    companion object {
        private var INSTANCE: PokemonDatabase? = null
        val migration_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE pokemon ADD COLUMN name TEXT DEFAULT ''")
            }
        }

        fun getAppDatabase(context: Context): PokemonDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<PokemonDatabase>(
                    context.applicationContext, PokemonDatabase::class.java, "APPDBB"
                )
                    .addMigrations(migration_1_2)
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}