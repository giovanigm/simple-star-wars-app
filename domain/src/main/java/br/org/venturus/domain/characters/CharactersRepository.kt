package br.org.venturus.domain.characters

import io.reactivex.Single

interface CharactersRepository {

    fun getCharactersList(): Single<List<CharacterEntity>>

    fun getCharacter(characterId: Int): Single<CharacterEntity>

}