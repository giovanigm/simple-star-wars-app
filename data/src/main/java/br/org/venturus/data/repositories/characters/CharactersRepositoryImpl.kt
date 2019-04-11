package br.org.venturus.data.repositories.characters

import br.org.venturus.data.repositories.characters.local.LocalCharactersDataSource
import br.org.venturus.data.repositories.characters.remote.RemoteCharactersDataSource
import br.org.venturus.domain.characters.CharactersRepository
import br.org.venturus.domain.characters.CharacterEntity
import io.reactivex.Single

class CharactersRepositoryImpl(
    private val localCharactersDataSource: LocalCharactersDataSource,
    private val remoteCharactersDataSource: RemoteCharactersDataSource
): CharactersRepository {

    override fun getCharactersList(): Single<List<CharacterEntity>> =
        localCharactersDataSource.getCharactersList().flatMap {
            if (it.isEmpty())
                remoteCharactersDataSource.getCharacters()
                    .doOnSuccess { list ->
                        localCharactersDataSource.saveCharactersList(list)
                    }
            else
                Single.just(it)
        }

    override fun getCharacter(characterId: Int): Single<CharacterEntity> =
        localCharactersDataSource.getCharacter(characterId)
}