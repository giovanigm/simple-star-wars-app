package br.org.venturus.data.repositories.characters.local

import br.org.venturus.data.db.Database
import br.org.venturus.data.data.CharacterData
import br.org.venturus.data.mappers.CharacterDataEntityMapper
import br.org.venturus.data.mappers.CharacterEntityDataMapper
import br.org.venturus.domain.common.Mapper
import br.org.venturus.domain.characters.CharacterEntity
import io.reactivex.Single

class RoomCharactersDataSource(
    database: Database,
    private val entityToDataMapper: Mapper<CharacterEntity, CharacterData>,
    private val dataToEntityMapper: Mapper<CharacterData, CharacterEntity>
): LocalCharactersDataSource {

    private val charactersDao = database.getCharactersDao()

    override fun getCharactersList(): Single<List<CharacterEntity>> =
        charactersDao.getCharacters().map { results ->
            results.map { dataToEntityMapper.mapFrom(it) }
        }

    override fun getCharacter(characterId: Int): Single<CharacterEntity> =
        charactersDao.get(characterId).map { dataToEntityMapper.mapFrom(it) }

    override fun saveCharactersList(charactersEntities: List<CharacterEntity>) {
        charactersDao.saveAllCharacters(charactersEntities.map { entityToDataMapper.mapFrom(it) })
    }
}