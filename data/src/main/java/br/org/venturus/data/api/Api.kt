package br.org.venturus.data.api

import br.org.venturus.data.data.CharacterData
import br.org.venturus.data.data.PlanetData
import br.org.venturus.data.data.StarshipData
import br.org.venturus.data.data.VehicleData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/characters")
    fun getCharacters(): Single<CharactersListResult>

    @GET("/characters/{id}")
    fun getCharacter(@Path("id") characterId: Int): Single<CharacterData>

    @GET("/planets")
    fun getPlanets(): Single<List<PlanetData>>

    @GET("/starships")
    fun getStarships(): Single<List<StarshipData>>

    @GET("/vehicles")
    fun getVehicles(): Single<List<VehicleData>>

    companion object Factory {
        const val BASE_URL = "https://simple-star-wars-api.herokuapp.com/"
    }

}