package br.org.venturus.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.org.venturus.data.data.CharacterData
import br.org.venturus.data.data.PlanetData
import br.org.venturus.data.data.StarshipData
import br.org.venturus.data.data.VehicleData

@Database(entities = [CharacterData::class, PlanetData::class, StarshipData::class, VehicleData::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun getCharactersDao(): CharactersDao

}