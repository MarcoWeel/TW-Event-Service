package com.tacticalwolves.eventservice;

import com.google.gson.Gson;
import com.tacticalwolves.eventservice.controller.EventController;
import com.tacticalwolves.eventservice.entity.Event;
import com.tacticalwolves.eventservice.service.EventService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(controllers = EventController.class)
@AutoConfigureMockMvc(addFilters = false)
public class EventControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EventService eventService;

    List<Event> events = new ArrayList<Event>();
    Event eventOne = new Event();
    Event eventTwo = new Event();

    @BeforeEach
    public void setup() {
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
    public void ShouldReturnAllEvents() throws Exception {

        when(eventService.GetEvents()).thenReturn(events);
        this.mockMvc.perform(get("/events/")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void ShouldReturnEventById() throws Exception {
        when(eventService.GetEventById(0)).thenReturn(events.get(0));
        this.mockMvc.perform(get("/events/" + "0").accept(MediaType.parseMediaType("application/json;")))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value("0"))
                .andExpect(jsonPath("$.location").value("TestLocation"));
    }

    @Test
    public void ShouldReturnEventWhenSaved() throws Exception {
        when(eventService.SaveEvent(eventOne)).thenReturn(eventOne);

        Gson data = new Gson();
        MvcResult mvcResult = this.mockMvc.perform(post("/events/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(data.toJson(eventOne)))
                .andExpect(status().isOk())
                .andReturn();

    }


}
