package br.org.venturus.domain.starships

import io.reactivex.Single

class StarshipsInteractor(private val starshipsRepository: StarshipsRepository) {


    fun getStarshipsList(): Single<List<StarshipEntity>> =
            starshipsRepository.getStarshipsList()

    fun getStarship(starshipId: Int): Single<StarshipEntity> =
            starshipsRepository.getStarship(starshipId)

}