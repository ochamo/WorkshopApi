package org.workshop.cc6.workshopserver.data.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopUser;

import java.util.Optional;

@Repository

public interface UserRepository extends CrudRepository<WorkshopUser, Integer> {
    Optional<WorkshopUser> findByUserEmail(String userEmail);
}

