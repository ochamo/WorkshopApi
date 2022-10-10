package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehicleLine;
@Repository

public interface VehicleLineRepository extends JpaRepository<WorkshopVehicleLine, Integer> {}
