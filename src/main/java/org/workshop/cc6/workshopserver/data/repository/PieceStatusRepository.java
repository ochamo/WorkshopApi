package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopPieceStatus;
@Repository

public interface PieceStatusRepository extends JpaRepository<WorkshopPieceStatus, Integer> {}
