package com.tacticalwolves.eventservice.service;

import com.tacticalwolves.eventservice.entity.Event;
import com.tacticalwolves.eventservice.entity.EventImage;
import com.tacticalwolves.eventservice.repository.EventImageRepository;
import com.tacticalwolves.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventImageService {
    @Autowired
    private EventImageRepository repository;

    public EventImage SaveEventImage(EventImage eventImage){
        return repository.save(eventImage);
    }

    public List<EventImage> GetEventImages(){
        return repository.findAll();
    }

    public EventImage GetEventImageById(int Id){
        return repository.findById(Id).orElse(null);
    }

    public String DeleteEventImageById(int Id){
        repository.deleteById(Id);
        return "Event Deleted";
    }

    public EventImage UpdateEvent(EventImage eventImage) {
        EventImage ExistingEventImage = GetEventImageById(eventImage.getId());
        ExistingEventImage.setFileLocation(eventImage.getFileLocation());
        return repository.save(ExistingEventImage);
    }
}
