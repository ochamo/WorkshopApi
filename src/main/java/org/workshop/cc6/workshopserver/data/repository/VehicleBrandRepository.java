package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehicleBrand;

public interface VehicleBrandRepository extends CrudRepository<WorkshopVehicleBrand, Integer> {
}
