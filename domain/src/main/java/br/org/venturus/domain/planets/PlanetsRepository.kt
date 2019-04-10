package br.org.venturus.domain.planets

import io.reactivex.Single

interface PlanetsRepository {

    fun getPlanetsList(): Single<List<PlanetEntity>>

    fun getPlanet(planetId: Int): Single<PlanetEntity>

}