package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopPayment;
@Repository

public interface PaymentRepository extends CrudRepository<WorkshopPayment, Integer> {}
