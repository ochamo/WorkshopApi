package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopAppointment;

@Repository
public interface AppointmentRepository extends CrudRepository<WorkshopAppointment, Integer> {}
