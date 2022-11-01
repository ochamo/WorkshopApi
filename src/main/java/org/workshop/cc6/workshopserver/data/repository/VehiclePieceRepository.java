package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehiclePiece;

import java.util.List;

public interface VehiclePieceRepository extends JpaRepository<WorkshopVehiclePiece, Integer> {
    @Query(""" 
        SELECT p FROM WorkshopVehiclePiece AS p
        JOIN p.workshopPieceModel WHERE p.workshopPieceModel.modelId = :pieceModel
    """)
    List<WorkshopVehiclePiece> findAllByPieceModel(Integer pieceModel);
}
