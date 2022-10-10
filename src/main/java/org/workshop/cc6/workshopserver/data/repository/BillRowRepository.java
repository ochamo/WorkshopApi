package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopBillRow;

public interface BillRowRepository extends JpaRepository<WorkshopBillRow, Integer> {
}
