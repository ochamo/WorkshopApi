package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopBill;

public interface BillRepository extends CrudRepository<WorkshopBill, Integer> {}
