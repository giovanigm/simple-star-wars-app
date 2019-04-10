package br.org.venturus.domain.starships

import io.reactivex.Single

interface StarshipsRepository {

    fun getStarshipsList(): Single<List<StarshipEntity>>

    fun getStarship(starshipId: Int): Single<StarshipEntity>

}