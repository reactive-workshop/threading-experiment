package com.reactivedemo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventRepository repository;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        System.out.println("Current Thread Name: "
                        + Thread.currentThread().getName());

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createTutorial(@RequestBody Event event) {
        Event savedEvent = repository.save(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }
}
