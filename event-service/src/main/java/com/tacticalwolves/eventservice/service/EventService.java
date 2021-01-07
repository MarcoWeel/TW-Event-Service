package com.tacticalwolves.eventservice.service;

import com.tacticalwolves.eventservice.entity.Event;
import com.tacticalwolves.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    @Autowired
    private EventLocationService service;

    public Event SaveEvent(Event event){ return repository.save(event); }

    public List<Event> GetEvents(){
        return repository.findAll(Sort.by(Sort.Direction.DESC, "DateTime"));
    }

    public Event GetEventById(int Id){
        return repository.findById(Id).orElse(null);
    }

    public String DeleteEventById(int Id){
        repository.deleteById(Id);
        return "Event Deleted";
    }

    public Event UpdateEvent(Event event){
        Event ExistingEvent = GetEventById(event.getId());
        ExistingEvent.setName((event.getName()));
        ExistingEvent.setLocation(event.getLocation());
        return repository.save(ExistingEvent);
    }
}
