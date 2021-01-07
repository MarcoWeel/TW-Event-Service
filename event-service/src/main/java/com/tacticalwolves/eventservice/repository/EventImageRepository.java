package com.tacticalwolves.eventservice.repository;

import com.tacticalwolves.eventservice.entity.EventLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventImageRepository extends JpaRepository<EventLocation,Integer> {
    List<EventLocation> findByName(String name);
}
