package com.tacticalwolves.eventservice.repository;

import com.tacticalwolves.eventservice.entity.Event;
import com.tacticalwolves.eventservice.entity.EventImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventImageRepository extends JpaRepository<EventImage,Integer> {
}
