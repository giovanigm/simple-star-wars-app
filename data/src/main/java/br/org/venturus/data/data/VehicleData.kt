package br.org.venturus.data.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
data class VehicleData(
    @PrimaryKey
    var id: Int = -1
)