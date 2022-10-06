package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopWorkOrderDetail;
@Repository

public interface VehicleWorkOrderDetailRepository extends CrudRepository<WorkshopWorkOrderDetail, Integer> {}
