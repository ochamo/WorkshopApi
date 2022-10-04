package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopPurchaseOrder;

public interface PurchaseOrderRepository extends CrudRepository<WorkshopPurchaseOrder, Integer> {}
