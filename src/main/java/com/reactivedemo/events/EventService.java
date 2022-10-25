package com.reactivedemo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public List<Event> getAllEvents() {
        restTemplateBuilder.build().getForObject("https://httpbin.org/delay/30", ResponseStub.class);
        return List.of(new Event("1", "Geeknight-Bangalore", "Blockchain technologies"));
    }

    public Event upcomingEvent() {
        return new Event("1", "Reactive-workshop-Bangalore", "Reactive programming concepts");
    }
}

class ResponseStub { }