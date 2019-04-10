package br.org.venturus.data.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "starships")
data class StarshipData(
    @PrimaryKey
    var id: Int = -1
)