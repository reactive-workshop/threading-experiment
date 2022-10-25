package com.reactivedemo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class EventController {

    @Autowired
    EventService service;

    @GetMapping("/events")
    @Async("asyncExecutor")
    public CompletableFuture<ResponseEntity<List<Event>>> getAllEvents() {
        System.out.println("AllEvents request served by: "
                + Thread.currentThread().getName());

        return service.getAllEvents()
                .thenApply(events -> new ResponseEntity<>(events, HttpStatus.OK));

    }

    @GetMapping("/upcoming-event")
    @Async("asyncExecutor")
    public CompletableFuture<ResponseEntity<Event>> getUpcomingEvent() {
        System.out.println("UpcomingEvent request served by: "
                + Thread.currentThread().getName());

        return service.upcomingEvent()
                .thenApply(event -> new ResponseEntity<>(event, HttpStatus.OK));
    }
}