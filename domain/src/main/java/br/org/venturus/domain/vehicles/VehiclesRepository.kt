package br.org.venturus.domain.vehicles

import io.reactivex.Single

interface VehiclesRepository {

    fun getVehiclesList(): Single<List<VehicleEntity>>

    fun getVehicle(vehicleId: Int): Single<VehicleEntity>

}