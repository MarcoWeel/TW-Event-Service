package com.tacticalwolves.eventservice.controller;

import com.tacticalwolves.eventservice.entity.Event;
import com.tacticalwolves.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {
    @Autowired
    private EventService service;

    @PostMapping("/")
    public Event addEvent(@RequestBody Event event){return service.SaveEvent(event);}

    @GetMapping("/{Id}")
    public Event findEventById(@PathVariable int Id){return service.GetEventById(Id);}

    @GetMapping("/")
    public List<Event> findAllEvents(){return service.GetEvents();}

    @PutMapping("/")
    public Event updateEvent(@RequestBody Event event){return service.UpdateEvent(event);}

    @DeleteMapping("/{Id}")
    public String deleteEvent(@PathVariable int Id){return service.DeleteEventById(Id);}

}
