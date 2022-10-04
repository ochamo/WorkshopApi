package org.workshop.cc6.workshopserver.data.repository;


import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopLocation;

public interface LocationRepository extends CrudRepository<WorkshopLocation, Integer> { }
