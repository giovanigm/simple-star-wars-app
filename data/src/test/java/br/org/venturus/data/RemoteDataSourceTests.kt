package br.org.venturus.data;

import br.org.venturus.data.api.Api
import br.org.venturus.data.api.ApiFactory
import br.org.venturus.data.mappers.CharacterDataEntityMapper
import br.org.venturus.data.repositories.characters.remote.ApiCharactersDataSource
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test

class RemoteDataSourceTests {

    private lateinit var api: Api
    private lateinit var remotePeopleDataSource: ApiCharactersDataSource
    private val peopleDataEntityMapper = CharacterDataEntityMapper()
    private lateinit var testScheduler: TestScheduler

    @Before
    fun beforeRun() {
        api = ApiFactory.createApi()
        remotePeopleDataSource = ApiCharactersDataSource(api, peopleDataEntityMapper)
        testScheduler = TestScheduler()
    }

    @Test
    fun testListCharacters() {
        remotePeopleDataSource
            .getCharacters()
            .test()
            .values()
            .map { list -> list.map { println(it) } }
    }

    @Test
    fun testGetCharacter() {
        remotePeopleDataSource
            .getCharacter(1)
            .test()
            .values()
            .map { result -> print(result) }
    }
}