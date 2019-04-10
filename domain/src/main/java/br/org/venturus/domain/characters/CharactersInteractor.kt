package br.org.venturus.domain.characters

import io.reactivex.Single

class CharactersInteractor(private val charactersRepository: CharactersRepository) {

    fun getCharactersList(): Single<List<CharacterEntity>> =
       charactersRepository.getCharactersList()

    fun getCharacter(characterId: Int): Single<CharacterEntity> =
        charactersRepository.getCharacter(characterId)

}