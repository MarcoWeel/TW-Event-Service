package com.tacticalwolves.eventservice.repository;

import com.tacticalwolves.eventservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer>{
}
