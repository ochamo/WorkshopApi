package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopClientVehicle;
import org.workshop.cc6.workshopserver.data.entity.WorkshopVehicleModel;

import java.util.List;

@Repository

public interface ClientVehicleRepository extends JpaRepository<WorkshopClientVehicle, Integer> {
    @Modifying
    @Query("""
        UPDATE WorkshopClientVehicle w SET 
        w.workshopClientVehicleModel = :modelId,
        w.vehiclePlate = :newPlate,
        w.deleted = :deleted 
    """)
    WorkshopClientVehicle updateSome(WorkshopVehicleModel modelId, String newPlate, byte deleted);

    @Query("""
        SELECT w.VehicleId, w.workshopClient, w.workshopClientVehicleModel, w.vehiclePlate, w.deleted FROM WorkshopClientVehicle w
           JOIN w.workshopClient c WHERE c.clientId = :clientId
        
    """)
    List<WorkshopClientVehicle> getByClientId(int clientId);
}
