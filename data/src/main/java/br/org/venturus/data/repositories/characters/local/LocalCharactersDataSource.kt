package br.org.venturus.data.repositories.characters.local

import br.org.venturus.domain.characters.CharacterEntity
import io.reactivex.Single

interface LocalCharactersDataSource {

    fun getCharactersList(): Single<List<CharacterEntity>>

    fun getCharacter(characterId: Int): Single<CharacterEntity>

    fun saveCharactersList(charactersEntities: List<CharacterEntity>)

}