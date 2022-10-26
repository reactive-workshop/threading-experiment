package com.reactivedemo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EventController {

    @Autowired
    EventService service;

    @GetMapping("/events")
    public Flux<Event> getAllEvents() {

        System.out.println("AllEvents request served by: "
                + Thread.currentThread().getName());
        return service.getAllEvents();
    }

    @GetMapping("/upcoming-event")
    public Mono<Event> getUpcomingEvent() {
        System.out.println("UpcomingEvent request served by: "
                + Thread.currentThread().getName());

        return service.upcomingEvent();
    }
}