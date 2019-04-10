package br.org.venturus.data.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planets")
data class PlanetData(
    @PrimaryKey
    var id: Int = -1
)