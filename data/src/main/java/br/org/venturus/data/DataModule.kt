package br.org.venturus.data

import androidx.room.Room
import br.org.venturus.data.api.ApiFactory
import br.org.venturus.data.data.CharacterData
import br.org.venturus.data.db.Database
import br.org.venturus.data.mappers.CharacterDataEntityMapper
import br.org.venturus.data.mappers.CharacterEntityDataMapper
import br.org.venturus.data.repositories.characters.CharactersRepositoryImpl
import br.org.venturus.data.repositories.characters.local.LocalCharactersDataSource
import br.org.venturus.data.repositories.characters.local.MemoryCharactersDataSource
import br.org.venturus.data.repositories.characters.local.RoomCharactersDataSource
import br.org.venturus.data.repositories.characters.remote.ApiCharactersDataSource
import br.org.venturus.data.repositories.characters.remote.RemoteCharactersDataSource
import br.org.venturus.domain.characters.CharacterEntity
import br.org.venturus.domain.characters.CharactersRepository
import br.org.venturus.domain.common.Mapper
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {

    single { ApiFactory.createApi() }

    single(named("CharacterEntityToData")) { CharacterEntityDataMapper() as Mapper<CharacterEntity, CharacterData> }

    single(named("CharacterDataToEntity")) { CharacterDataEntityMapper() as Mapper<CharacterData, CharacterEntity> }

    single { Room.databaseBuilder(androidContext(), Database::class.java, "star-wars-db").build() }

    single { ApiCharactersDataSource(get(), get(named("CharacterDataToEntity"))) as RemoteCharactersDataSource }

    single { RoomCharactersDataSource(get(), get(named("CharacterEntityToData")), get(named("CharacterDataToEntity"))) as LocalCharactersDataSource }

    //single { MemoryCharactersDataSource() as LocalCharactersDataSource }

    single { CharactersRepositoryImpl(get(), get()) as CharactersRepository }

}