package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopClient;

public interface ClientRepository extends CrudRepository<WorkshopClient, Integer> { }
