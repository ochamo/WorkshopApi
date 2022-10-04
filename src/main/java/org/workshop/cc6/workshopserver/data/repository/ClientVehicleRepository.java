package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopClientVehicle;

public interface ClientVehicleRepository extends CrudRepository<WorkshopClientVehicle, Integer> {}
