package com.dancoghlan.runtracker.repository;

import com.dancoghlan.runtracker.entity.RunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RunRepository extends JpaRepository<RunEntity, Long> {

    @Query(value = "SELECT SUM(distance) as total_distance FROM RunEntity r", nativeQuery = true)
    Double getTotalDistance();

}
