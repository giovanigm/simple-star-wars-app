package br.org.venturus.data.mappers

import br.org.venturus.data.data.CharacterData
import br.org.venturus.domain.common.Mapper
import br.org.venturus.domain.characters.CharacterEntity

class CharacterDataEntityMapper: Mapper<CharacterData, CharacterEntity> {
    override fun mapFrom(from: CharacterData): CharacterEntity {
        return CharacterEntity(
            id = from.id,
            name = from.name,
            height = from.height,
            mass = from.mass,
            hairColor = from.hairColor,
            skinColor = from.skinColor,
            eyeColor = from.eyeColor,
            birthYear = from.birthYear,
            gender = from.gender,
            homeworld = from.homeworld,
            imageUrl = from.imageUrl
        )
    }
}