package br.org.venturus.data

import androidx.room.Room
import br.org.venturus.data.api.ApiFactory
import br.org.venturus.data.db.Database
import br.org.venturus.data.mappers.CharacterDataEntityMapper
import br.org.venturus.data.mappers.CharacterEntityDataMapper
import br.org.venturus.data.repositories.characters.CharactersRepositoryImpl
import br.org.venturus.data.repositories.characters.local.LocalCharactersDataSource
import br.org.venturus.data.repositories.characters.local.RoomCharactersDataSource
import br.org.venturus.data.repositories.characters.remote.ApiCharactersDataSource
import br.org.venturus.data.repositories.characters.remote.RemoteCharactersDataSource
import br.org.venturus.domain.characters.CharactersRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single { ApiFactory.createApi() }

    single { CharacterEntityDataMapper() }

    single { CharacterDataEntityMapper() }

    single { Room.inMemoryDatabaseBuilder(androidContext(), Database::class.java).build() }

    single { ApiCharactersDataSource(get(), get()) as RemoteCharactersDataSource }

    single { RoomCharactersDataSource(get(), get(), get()) as LocalCharactersDataSource }

    single { CharactersRepositoryImpl(get(), get()) as CharactersRepository }

}