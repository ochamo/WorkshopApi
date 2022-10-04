package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopAdvisor;
import org.workshop.cc6.workshopserver.data.entity.WorkshopBillRow;

public interface AdvisorRepository extends CrudRepository<WorkshopAdvisor, Integer> {
    interface BillRowRepository extends CrudRepository<WorkshopBillRow, Integer> { }
}
