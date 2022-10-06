package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopUser;
@Repository

public interface WorkshopUserRepository extends CrudRepository<WorkshopUser, Integer> {}
