package br.org.venturus.domain.characters

data class CharacterEntity(
    val id: Int,
    var name : String? = null,
    var height : String? = null,
    var mass : String? = null,
    var hairColor : String? = null,
    var skinColor : String? = null,
    var eyeColor : String? = null,
    var birthYear : String? = null,
    var gender : String? = null,
    var homeworld : String? = null,
    var imageUrl: String? = null
)