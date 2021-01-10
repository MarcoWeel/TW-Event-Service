package com.tacticalwolves.eventservice.controller;

import com.tacticalwolves.eventservice.entity.EventLocation;
import com.tacticalwolves.eventservice.service.EventLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RestController
@RequestMapping("/events")
@CrossOrigin
public class EventLocationController {
    @Autowired
    private EventLocationService service;

    @RolesAllowed({"ADMIN", "MEMBER"})
    @PostMapping("/location")
    public EventLocation addEventLocation(@RequestBody EventLocation eventLocation) { return service.SaveEventLocation(eventLocation);}

    @GetMapping("/location/{Id}")
    public EventLocation findEventLocationById(@PathVariable int Id){return service.GetEventLocationById(Id);}

    @GetMapping("/location")
    public List<EventLocation> findAllEventLocations(){return service.GetEventLocations();}

    @RolesAllowed({"ADMIN", "MEMBER"})
    @PutMapping("/location")
    public EventLocation updateEventLocation(@RequestBody EventLocation event){return service.UpdateEventLocation(event);}

    @RolesAllowed({"ADMIN", "MEMBER"})
    @DeleteMapping("/location")
    public String deleteLocation(@PathVariable int Id){return service.DeleteEventLocationById(Id);}
}
