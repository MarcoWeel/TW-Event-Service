package com.tacticalwolves.eventservice.service;

import com.tacticalwolves.eventservice.entity.EventLocation;
import com.tacticalwolves.eventservice.repository.EventImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventLocationService {
    @Autowired
    private EventImageRepository repository;

    public EventLocation SaveEventLocation(EventLocation eventLocation){
        return repository.save(eventLocation);
    }

    public List<EventLocation> GetEventLocations(){
        return repository.findAll();
    }

    public EventLocation GetEventLocationById(int Id){
        return repository.findById(Id).orElse(null);
    }

    public String DeleteEventLocationById(int Id){
        repository.deleteById(Id);
        return "Event Deleted";
    }

    public EventLocation UpdateEventLocation(EventLocation eventLocation) {
        EventLocation existingEventLocation = GetEventLocationById(eventLocation.getId());
        existingEventLocation.setFileLocation(eventLocation.getFileLocation());
        return repository.save(existingEventLocation);
    }
}
