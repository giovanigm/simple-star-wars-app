package br.org.venturus.domain.planets

import br.org.venturus.domain.characters.CharacterEntity

data class PlanetEntity(
    val id: Int,
    var name: String? = null,
    var rotationPeriod: Int? = null,
    var orbitalPeriod: Int? = null,
    var diameter: Int? = null,
    var climate: String? = null,
    var gravity: String? = null,
    var terrain: String? = null,
    var surfaceWater: String? = null,
    var population: Int? = null,
    var residents: List<CharacterEntity>? = null
)