package com.reactivedemo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EventService {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public CompletableFuture<List<Event>> getAllEvents() {
        restTemplateBuilder.build().getForObject("https://httpbin.org/delay/30", ResponseStub.class);
        return CompletableFuture.completedFuture(List.of(new Event("1", "Geeknight-Bangalore", "Blockchain technologies")));
    }

    @Async("asyncExecutor")
    public CompletableFuture<Event> upcomingEvent() {
        return CompletableFuture.completedFuture(new Event("1", "Reactive-workshop-Bangalore", "Reactive programming concepts"));
    }
}

class ResponseStub { }