package org.workshop.cc6.workshopserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopClient;

import java.util.Optional;

@Repository

public interface ClientRepository extends CrudRepository<WorkshopClient, Integer> {
    Optional<WorkshopClient> findByUserId(Integer userId);
}
