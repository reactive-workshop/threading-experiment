package com.reactivedemo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService service;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        System.out.println("AllEvents request served by: "
                + Thread.currentThread().getName());

        List<Event> allEvents = service.getAllEvents();

        return new ResponseEntity<>(allEvents, HttpStatus.OK);
    }

    @GetMapping("/upcoming-event")
    public ResponseEntity<Event> getUpcomingEvent() {
        System.out.println("UpcomingEvent request served by: "
                + Thread.currentThread().getName());

        Event event = service.upcomingEvent();

        return new ResponseEntity<>(event, HttpStatus.OK);
    }
}