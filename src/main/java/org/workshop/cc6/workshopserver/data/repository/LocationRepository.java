package org.workshop.cc6.workshopserver.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.workshop.cc6.workshopserver.data.entity.WorkshopLocation;

import java.util.List;

@Repository

public interface LocationRepository extends JpaRepository<WorkshopLocation, Integer> {
    @Query("SELECT w FROM WorkshopLocation w WHERE w.deleted <> 1")
    <S extends WorkshopLocation> List<S> findAllNotDeleted();
}
