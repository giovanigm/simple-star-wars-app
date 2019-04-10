package br.org.venturus.domain.planets

import io.reactivex.Single

class PlanetsInteractor(private val planetsRepository: PlanetsRepository) {

    fun getPlanetsList(): Single<List<PlanetEntity>> =
            planetsRepository.getPlanetsList()

    fun getPlanet(planetId: Int): Single<PlanetEntity> =
            planetsRepository.getPlanet(planetId)

}