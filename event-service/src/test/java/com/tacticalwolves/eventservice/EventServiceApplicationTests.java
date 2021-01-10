package com.tacticalwolves.eventservice;


import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


import com.tacticalwolves.eventservice.entity.Event;
import com.tacticalwolves.eventservice.repository.EventRepository;
import com.tacticalwolves.eventservice.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EventServiceApplicationTests {


    @Autowired
    private EventService eventService;

    @MockBean
    private EventRepository eventRepository;

    List<Event> events = new ArrayList<Event>();
    Event eventOne = new Event();
    Event eventTwo = new Event();

    @BeforeEach
    public void setup(){
        eventOne.setId(0);
        eventOne.setLocationUrl("Http://TestURL.com");
        eventOne.setLocation("TestLocation");
        eventOne.setName("TestName");
        eventTwo.setId(1);
        eventTwo.setLocationUrl("Http://TestURL.com");
        eventTwo.setLocation("TestLocation");
        eventTwo.setName("TestName");
        events.add(eventOne);
        events.add(eventTwo);
    }

    @Test
    public void ShouldReturnAllObjectsFromService() throws Exception {
        when(eventRepository.findAll(Sort.by(Sort.Direction.DESC, "DateTime"))).thenReturn(events);

        List<Event> eventsReturned = eventService.GetEvents();

        assertEquals(eventsReturned.get(0).getLocation(), eventOne.getLocation());
        assertEquals(eventsReturned.get(0).getLocationUrl(), eventOne.getLocationUrl());
        assertEquals(eventsReturned.get(0).getName(), eventOne.getName());
        assertEquals(eventsReturned.get(1).getLocation(), eventTwo.getLocation());
        assertEquals(eventsReturned.get(1).getLocationUrl(), eventTwo.getLocationUrl());
        assertEquals(eventsReturned.get(1).getName(), eventTwo.getName());
        assertEquals(eventsReturned.size(), 2);
        verify(eventRepository, times(1)).findAll(Sort.by(Sort.Direction.DESC, "DateTime"));
    }

    @Test
    public void ShouldReturnObjectByIndex() throws Exception {
        when(eventRepository.findById(0)).thenReturn(Optional.of(eventOne));

        Event eventReturned = eventService.GetEventById(0);

        assertEquals(eventReturned.getLocation(), eventOne.getLocation());
        assertEquals(eventReturned.getLocationUrl(), eventOne.getLocationUrl());
        assertEquals(eventReturned.getName(), eventOne.getName());
        verify(eventRepository, times(1)).findById(0);
    }

    @Test
    public void ShouldReturnStringWhenDelete() throws Exception {
        doNothing().when(eventRepository).deleteById(0);

        String StringReturned = eventService.DeleteEventById(0);

        assertEquals(StringReturned, "Event Deleted");
        verify(eventRepository, times(1)).deleteById(0);
    }

    @Test
    public void ShouldReturnEventWhenSaved() throws Exception {
        when(eventRepository.save(eventOne)).thenReturn(eventOne);

        Event eventReturned = eventService.SaveEvent(eventOne);

        assertEquals(eventReturned.getLocation(), eventOne.getLocation());
        assertEquals(eventReturned.getLocationUrl(), eventOne.getLocationUrl());
        assertEquals(eventReturned.getName(), eventOne.getName());
        verify(eventRepository, times(1)).save(eventOne);
    }
}

