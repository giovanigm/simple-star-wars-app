package br.org.venturus.data.repositories.characters.local

import br.org.venturus.domain.characters.CharacterEntity
import io.reactivex.Single

class MemoryCharactersDataSource: LocalCharactersDataSource {

    private val characters: LinkedHashMap<Int, CharacterEntity> = LinkedHashMap()

    override fun getCharactersList(): Single<List<CharacterEntity>> =
        Single.just(characters.values.toList())

    override fun getCharacter(characterId: Int): Single<CharacterEntity> =
        Single.just(characters[characterId])

    override fun saveCharactersList(charactersEntities: List<CharacterEntity>) {
        charactersEntities.forEach { characterEntity -> this.characters[characterEntity.id] = characterEntity }
    }
}