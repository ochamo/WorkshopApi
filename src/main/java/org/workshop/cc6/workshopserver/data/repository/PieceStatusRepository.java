package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopPieceStatus;

public interface PieceStatusRepository extends CrudRepository<WorkshopPieceStatus, Integer> {}
