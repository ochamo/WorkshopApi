package org.workshop.cc6.workshopserver.data.repository;


import org.springframework.data.repository.CrudRepository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopUser;

public interface UserRepository extends CrudRepository<WorkshopUser, Integer> {}

