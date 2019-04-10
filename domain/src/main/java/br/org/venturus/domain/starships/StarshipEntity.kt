package br.org.venturus.domain.starships

data class StarshipEntity(
    val id: Int,
    var name: String? = null,
    var model: String? = null,
    var manufacturer: String? = null,
    var cost: Int? = null,
    var length: Double? = null,
    var maxSpeed: Int? = null,
    var passengers: Int? = null,
    var starshipClass: String? = null,
    var hyperdriveRating: Double? = null
)