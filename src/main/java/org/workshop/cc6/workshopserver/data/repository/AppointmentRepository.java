package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopAppointment;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<WorkshopAppointment, Integer> {
    @Query("""
    SELECT a FROM WorkshopAppointment AS a JOIN a.appointmentAdvisor
        JOIN a.appointmentClient
        JOIN a.appointmentLocation
        WHERE a.appointmentClient.clientId = :clientId
    """)
    List<WorkshopAppointment> findByClientId(Integer clientId);
}
