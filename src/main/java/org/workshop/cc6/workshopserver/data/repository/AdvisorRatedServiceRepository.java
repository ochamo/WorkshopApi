package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopAdvisorRatedService;

public interface AdvisorRatedServiceRepository extends CrudRepository<WorkshopAdvisorRatedService, Integer> {}
