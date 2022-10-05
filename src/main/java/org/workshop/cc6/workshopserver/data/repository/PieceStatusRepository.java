package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopPieceStatus;
@Repository

public interface PieceStatusRepository extends CrudRepository<WorkshopPieceStatus, Integer> {}
