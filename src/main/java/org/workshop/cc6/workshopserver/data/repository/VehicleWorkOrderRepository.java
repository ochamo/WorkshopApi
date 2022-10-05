package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopWorkOrder;
@Repository

public interface VehicleWorkOrderRepository extends CrudRepository<WorkshopWorkOrder, Integer> {}
