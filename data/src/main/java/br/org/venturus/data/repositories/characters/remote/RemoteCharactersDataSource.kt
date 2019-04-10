package br.org.venturus.data.repositories.characters.remote

import br.org.venturus.domain.characters.CharacterEntity
import io.reactivex.Single

interface RemoteCharactersDataSource {

    fun getCharacters(): Single<List<CharacterEntity>>

    fun getCharacter(characterId: Int): Single<CharacterEntity>

}