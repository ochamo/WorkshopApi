package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopPayment;

public interface PaymentRepository extends CrudRepository<WorkshopPayment, Integer> {}
