package com.tacticalwolves.eventservice.controller;

import com.tacticalwolves.eventservice.entity.Event;
import com.tacticalwolves.eventservice.entity.Provider;
import com.tacticalwolves.eventservice.proxies.ProviderProxy;
import com.tacticalwolves.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {
    @Autowired
    private EventService service;

    @Autowired
    private ProviderProxy providerProxy;

    @RolesAllowed({"ADMIN", "MEMBER"})
    @PostMapping("")
    public Event addEvent(@RequestBody Event event){return service.SaveEvent(event);}

    @GetMapping("/{Id}")
    public Event findEventById(@PathVariable int Id){return service.GetEventById(Id);}

    @GetMapping("")
    public List<Event> findAllEvents(){return service.GetEvents();}

    @RolesAllowed({"ADMIN", "MEMBER"})
    @PutMapping("")
    public Event updateEvent(@RequestBody Event event){return service.UpdateEvent(event);}

    @RolesAllowed({"ADMIN", "MEMBER"})
    @DeleteMapping("/{Id}")
    public String deleteEvent(@PathVariable int Id){return service.DeleteEventById(Id);}

//    @GetMapping("/{id}")
//    public ResponseEntity<Event> getDetails(@PathVariable String id) {
//        Optional<Event> event$ = products.stream().filter(p -> id.equals(p.getId())).findFirst();
//        if (!event$.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        Event event = event$.get();
//        Provider provider = providerProxy.getDetails(event.getProviderId());
//        product.setProvider(provider);
//        return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
//    }
}
