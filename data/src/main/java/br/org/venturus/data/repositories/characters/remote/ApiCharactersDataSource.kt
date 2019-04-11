package br.org.venturus.data.repositories.characters.remote

import br.org.venturus.data.api.Api
import br.org.venturus.data.data.CharacterData
import br.org.venturus.domain.common.Mapper
import br.org.venturus.domain.characters.CharacterEntity
import io.reactivex.Single

class ApiCharactersDataSource(
    private val api: Api,
    private val dataToEntityMapper: Mapper<CharacterData, CharacterEntity>
): RemoteCharactersDataSource {

    override fun getCharacters(): Single<List<CharacterEntity>> =
            api.getCharacters().map { result -> result.characters.map { dataToEntityMapper.mapFrom(it) } }


    override fun getCharacter(characterId: Int): Single<CharacterEntity> =
            api.getCharacter(characterId).map { dataToEntityMapper.mapFrom(it) }
}