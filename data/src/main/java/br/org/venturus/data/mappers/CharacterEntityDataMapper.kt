package br.org.venturus.data.mappers

import br.org.venturus.data.data.CharacterData
import br.org.venturus.domain.common.Mapper
import br.org.venturus.domain.characters.CharacterEntity
import br.org.venturus.domain.planets.PlanetEntity

class CharacterEntityDataMapper: Mapper<CharacterEntity, CharacterData> {

    override fun mapFrom(from: CharacterEntity): CharacterData {
        return CharacterData(
            id = from.id,
            name = from.name?: "",
            height = from.height?: "",
            mass = from.mass?: "",
            hairColor = from.hairColor?: "",
            skinColor = from.skinColor?: "",
            eyeColor = from.eyeColor?: "",
            birthYear = from.birthYear?: "",
            gender = from.gender?: "",
            homeworld = from.homeworld?: "",
            imageUrl = from.imageUrl?: ""
        )
    }
}