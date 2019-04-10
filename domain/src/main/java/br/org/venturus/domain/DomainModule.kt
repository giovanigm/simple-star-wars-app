package br.org.venturus.domain

import br.org.venturus.domain.characters.CharactersInteractor
import br.org.venturus.domain.planets.PlanetsInteractor
import br.org.venturus.domain.starships.StarshipsInteractor
import br.org.venturus.domain.vehicles.VehiclesInteractor
import org.koin.dsl.module

val domainModule = module {

    single { CharactersInteractor(get()) }

    single { PlanetsInteractor(get()) }

    single { StarshipsInteractor(get()) }

    single { VehiclesInteractor(get()) }
}