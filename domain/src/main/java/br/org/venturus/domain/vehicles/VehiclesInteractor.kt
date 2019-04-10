package br.org.venturus.domain.vehicles

import io.reactivex.Single

class VehiclesInteractor(private val vehiclesRepository: VehiclesRepository) {

    fun getVehiclesList(): Single<List<VehicleEntity>> =
            vehiclesRepository.getVehiclesList()

    fun getVehicle(vehicleId: Int): Single<VehicleEntity> =
            vehiclesRepository.getVehicle(vehicleId)

}